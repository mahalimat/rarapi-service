package com.rar.api.controller;

import com.rar.api.entity.Site;
import com.rar.api.service.SiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/site")
@CrossOrigin(origins = "http://localhost:3000")
public class SiteController {

    private SiteService siteService;
    @PostMapping
    public ResponseEntity<Site> addSite(@RequestBody Site site) {
        Site addedSite = siteService.addSite(site);

        return new ResponseEntity<>(addedSite, HttpStatus.CREATED);
    }

    // http://localhost:8081/api/site/1
    @GetMapping("{id}")
    public ResponseEntity<Site> getSiteById(@PathVariable("id") Integer siteId) {
        Site site = siteService.getSiteById(siteId);

        return new ResponseEntity<>(site, HttpStatus.OK);
    }

    // http://localhost:8081/api/site/all
    @GetMapping("all")
    public ResponseEntity<List<Site>> getAllSites() {
        List<Site> sites = siteService.getAllSites();

        return new ResponseEntity<>(sites, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Site> updateSite(@RequestBody Site site) {
        Site updatedSite = siteService.updateSite(site);

        return new ResponseEntity<>(updatedSite, HttpStatus.OK);
    }

    // http://localhost:8081/api/site/1
    @PutMapping("{id}")
    public ResponseEntity<Site> updateSiteById(@PathVariable("id") Integer siteId,
                                               @RequestBody Site site) {
        site.setSiteId(siteId);
        Site updatedSite = siteService.updateSiteById(site);

        return new ResponseEntity<>(updatedSite, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteSite(@PathVariable("id") Integer siteId) {
        siteService.deleteSite(siteId);

        return new ResponseEntity<>(siteId, HttpStatus.OK);
    }

}
