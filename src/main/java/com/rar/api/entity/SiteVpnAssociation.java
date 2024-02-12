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
@Table(name = "siteVpnAssociation")
public class SiteVpnAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siteVpnAsscInstanceId;
    @ManyToOne
    @JoinColumn(name="site_id")
    private Site site;
    @ManyToOne
    @JoinColumn(name="vpn_id")
    private Vpn vpn;
    private String siteOriginCode;
    @OneToMany(mappedBy = "siteVpnAssociation")
    private List<RouterVpnAssociation> routerVpnAssociations;
}
