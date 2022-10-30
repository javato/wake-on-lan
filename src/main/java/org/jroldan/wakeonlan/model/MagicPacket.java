package org.jroldan.wakeonlan.model;

import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MagicPacket {
    private DatagramPacket packet;

    public MagicPacket(DatagramPacket packet) {
        this.packet = packet;
    }

    public DatagramPacket getPacket() {
        return packet;
    }

    public void setPacket(DatagramPacket packet) {
        this.packet = packet;
    }
}
