package com.rar.api.service.impl;

import com.rar.api.entity.Vpn;
import com.rar.api.repository.VpnRepository;
import com.rar.api.service.VpnService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VpnServiceImpl implements VpnService {

    private VpnRepository vpnRepository;
    @Override
    public Vpn addVpn(Vpn vpn) {
        Vpn addedVpn = vpnRepository.save(vpn);

        return addedVpn;
    }

    @Override
    public Vpn getVpnById(Integer vpnId) {
        Vpn vpn = vpnRepository.findById(vpnId).get();

        return vpn;
    }

    @Override
    public List<Vpn> getAllVpn() {
        List<Vpn> vpns = vpnRepository.findAll();

        return vpns;
    }

    @Override
    public Vpn updateVpn(Vpn vpn) {
        return vpnRepository.save(vpn);
    }

    @Override
    public Vpn updateVpnById(Vpn vpn) {
        Vpn existingVpn = vpnRepository.findById(vpn.getVpnId()).get();
        existingVpn.setVpnName(vpn.getVpnName());
        existingVpn.setVrf(vpn.getVrf());
        existingVpn.setRouteDistinguisher(vpn.getRouteDistinguisher());
        existingVpn.setRouteTarget(vpn.getRouteTarget());

        Vpn updatedVpn = vpnRepository.save(existingVpn);

        return updatedVpn;

    }

    @Override
    public void deleteVpn(Integer vpnId) {
         vpnRepository.deleteById(vpnId);
    }
}
