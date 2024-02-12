package com.rar.api.controller;

import com.rar.api.entity.Vpn;
import com.rar.api.service.VpnService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/vpn")
@CrossOrigin(origins = "http://localhost:3000")
public class VpnController {

    private VpnService vpnService;

    @PostMapping
    public ResponseEntity<Vpn> addVpn(@RequestBody Vpn vpn) {
        Vpn addedVpn = vpnService.addVpn(vpn);

        return new ResponseEntity<>(addedVpn, HttpStatus.CREATED);
    }

    // http://localhost:8081/api/vpn/1
    @GetMapping("{id}")
    public ResponseEntity<Vpn> getVpnById(@PathVariable("id") Integer vpnId) {
        Vpn vpn = vpnService.getVpnById(vpnId);

        return new ResponseEntity<>(vpn, HttpStatus.OK);
    }

    // http://localhost:8081/api/vpn/all
    @GetMapping("all")
    public ResponseEntity<List<Vpn>> getAllVpn() {
        List<Vpn> vpns = vpnService.getAllVpn();

        return new ResponseEntity<>(vpns, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Vpn> updateVpn(@RequestBody Vpn vpn) {
        Vpn updatedVpn = vpnService.updateVpn(vpn);

        return  new ResponseEntity<>(updatedVpn, HttpStatus.OK);
    }

    // http://localhost:8081/api/vpn/1
    @PutMapping("{id}")
    public ResponseEntity<Vpn> updateVpnById(@PathVariable("id") Integer vpnId,
                                             @RequestBody Vpn vpn) {
        vpn.setVpnId(vpnId);

        Vpn updatedVpn = vpnService.updateVpnById(vpn);

        return new ResponseEntity<>(updatedVpn, HttpStatus.OK);
    }

    // http://localhost:8081/api/vpn/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVpn(@PathVariable("id") Integer vpnId) {
        vpnService.deleteVpn(vpnId);

        return new ResponseEntity<>("Vpn deleted successfully!", HttpStatus.OK);
    }
}
