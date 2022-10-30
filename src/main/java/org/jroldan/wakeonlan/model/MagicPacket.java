package org.jroldan.wakeonlan.model;

import java.net.DatagramPacket;

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
