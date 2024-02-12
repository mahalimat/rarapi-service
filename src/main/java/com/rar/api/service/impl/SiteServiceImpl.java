package com.rar.api.service.impl;

import com.rar.api.entity.Site;
import com.rar.api.repository.SiteRepository;
import com.rar.api.service.SiteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SiteServiceImpl implements SiteService {
    private SiteRepository siteRepository;

    @Override
    public Site addSite(Site site) {
        return siteRepository.save(site);
    }

    @Override
    public Site getSiteById(Integer siteId) {
        Optional<Site> optionalSite = siteRepository.findById(siteId);
        return optionalSite.get();
    }

    @Override
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    @Override
    public Site updateSite(Site site) {

        return siteRepository.save(site);
    }

    @Override
    public Site updateSiteById(Site site) {
        Site existingSite = siteRepository.findById(site.getSiteId()).get();
        existingSite.setSiteName(site.getSiteName());
        existingSite.setSiteAs(site.getSiteAs());
        existingSite.setSiteAddress(site.getSiteAddress());

        Site updatedSite = siteRepository.save(existingSite);

        return updatedSite;
    }

    @Override
    public void deleteSite(Integer siteId) {
        siteRepository.deleteById(siteId);
    }
}
