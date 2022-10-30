package org.jroldan.wakeonlan.service;

public interface MagicPacketService {
    public void sendMagicPacket(String ipAddress, String macAddress);
}
