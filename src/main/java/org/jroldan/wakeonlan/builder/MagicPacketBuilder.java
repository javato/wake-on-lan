package org.jroldan.wakeonlan.builder;

import org.jroldan.wakeonlan.model.MagicPacket;

public interface MagicPacketBuilder {
    public MagicPacket build(String ipAddress, String macAddress);

}
