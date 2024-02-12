package com.rar.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "routerVpnAssociation")
public class RouterVpnAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routerVpnAsscInstanceId;
    @ManyToOne
    @JoinColumn(name = "router_id")
    private Router router;
    @ManyToOne
    @JoinColumn(name = "site_vpn_assn_id")
    private SiteVpnAssociation siteVpnAssociation;
    private String ipAddress;
}
