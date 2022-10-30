package org.jroldan.wakeonlan.controller;

import org.jroldan.wakeonlan.service.MagicPacketService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MagicPacketController {

    private final MagicPacketService magicPacketService;

    public MagicPacketController(MagicPacketService magicPacketService) {
        this.magicPacketService = magicPacketService;
    }

    @PostMapping("/magic-packet")
    @ResponseStatus(HttpStatus.OK)
    public void sendMagicPacket(@RequestParam String ipAddress, @RequestParam String macAddress) {
        magicPacketService.sendMagicPacket(ipAddress, macAddress);
    }
}
