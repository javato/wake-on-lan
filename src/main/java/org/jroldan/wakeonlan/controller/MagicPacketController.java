package org.jroldan.wakeonlan.controller;

import org.jroldan.wakeonlan.service.MagicPacketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MagicPacketController {

    private static Logger log = LoggerFactory.getLogger(MagicPacketController.class);

    private final MagicPacketService magicPacketService;

    public MagicPacketController(MagicPacketService magicPacketService) {
        this.magicPacketService = magicPacketService;
    }

    @PostMapping("/magic-packet")
    @ResponseStatus(HttpStatus.OK)
    public void sendMagicPacket(@RequestParam String ipAddress, @RequestParam String macAddress) {
        log.info("New request for ipAddress: {}, macAddress: {}", ipAddress, macAddress);
        magicPacketService.sendMagicPacket(ipAddress, macAddress);
    }
}
