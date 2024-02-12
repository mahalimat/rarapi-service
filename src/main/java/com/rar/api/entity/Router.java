package com.rar.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "router")
public class Router {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routerId;
    @Column(nullable = false, unique = true)
    private String routerName;
    @Column(nullable = false, unique = true)
    private String ipAddress;
    @JsonIgnoreProperties("routers")
    @ManyToOne
    @JoinColumn(name="site_id")
    private Site site;
    @OneToMany(mappedBy = "router")
    private List<RouterVpnAssociation> routerVpnAssociations;

}
