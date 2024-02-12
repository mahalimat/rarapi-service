package com.rar.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer siteId;
    @Column(nullable = false, unique = true)
    private String siteName;
    private String siteAs;
    private String siteAddress;
    @JsonIgnoreProperties("site")
    @OneToMany(mappedBy = "site")
    private List<Router> routers;
    @OneToMany(mappedBy = "site")
    private List<SiteVpnAssociation> siteVpnAssociations;
}
