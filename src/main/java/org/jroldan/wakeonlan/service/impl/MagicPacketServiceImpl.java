package org.jroldan.wakeonlan.service.impl;

import org.jroldan.wakeonlan.builder.MagicPacketBuilder;
import org.jroldan.wakeonlan.service.MagicPacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.DatagramSocket;

@Service
public class MagicPacketServiceImpl implements MagicPacketService {

    private static Logger log = LoggerFactory.getLogger(MagicPacketServiceImpl.class);

    private final MagicPacketBuilder magicPacketBuilder;

    public MagicPacketServiceImpl(MagicPacketBuilder magicPacketBuilder) {
        this.magicPacketBuilder = magicPacketBuilder;
    }

    @Override
    public void sendMagicPacket(String ipAddress, String macAddress) {

        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setBroadcast(true);
            socket.send(magicPacketBuilder.build(ipAddress, macAddress).getPacket());

        } catch (Exception e) {
            log.error("Failed to send WoL packet:", e);
        }
    }
}
