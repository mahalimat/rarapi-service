package com.rar.api.service;

import com.rar.api.entity.Vpn;

import java.util.List;

public interface VpnService {
    Vpn addVpn(Vpn vpn);

    Vpn getVpnById(Integer vpnId);

    List<Vpn> getAllVpn();

    Vpn updateVpn(Vpn vpn);

    Vpn updateVpnById(Vpn vpn);

    void deleteVpn(Integer vpnId);
}
