package org.jroldan.wakeonlan.builder.impl;

import org.jroldan.wakeonlan.builder.MagicPacketBuilder;
import org.jroldan.wakeonlan.model.MagicPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.DatagramPacket;
import java.net.InetAddress;

@Component
public class MagicPacketBuilderImpl implements MagicPacketBuilder {

    private static Logger log = LoggerFactory.getLogger(MagicPacketBuilderImpl.class);

    @Override
    public MagicPacket build(String ipAddress, String macAddress) {
        DatagramPacket packet = null;

        try {
            final byte[] macBytes = getMacBytes(macAddress);
            final byte[] bytes = new byte[6 + 16 * macBytes.length];
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) 0xff;
            }
            for (int i = 6; i < bytes.length; i += macBytes.length) {
                System.arraycopy(macBytes, 0, bytes, i, macBytes.length);
            }

            InetAddress address = InetAddress.getByName(ipAddress.replaceAll("\\d{1,}$", "255"));
            packet = new DatagramPacket(bytes, bytes.length, address, 9);

        } catch (Exception e) {
            log.error("Failed to build Magic Packet:", e);
        }

        return new MagicPacket(packet);
    }

    private byte[] getMacBytes(String macAddress) throws IllegalArgumentException {
        final byte[] bytes = new byte[6];
        final String[] hex = macAddress.split("(\\:|\\-)");
        if (hex.length != 6) {
            throw new IllegalArgumentException("Invalid MAC address.");
        }
        try {
            for (int i = 0; i < 6; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hex digit in MAC address.");
        }
        return bytes;
    }
}
