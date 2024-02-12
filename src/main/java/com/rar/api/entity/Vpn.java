package com.rar.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vpn")
public class Vpn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vpnId;
    @Column(nullable = false)
    private String vpnName;
    @Column(nullable = false)
    private  String vrf;
    @Column(nullable = false)
    private String routeDistinguisher;
    private String routeTarget;
    @OneToMany(mappedBy = "vpn")
    private List<SiteVpnAssociation> siteVpnAssociations;
}
