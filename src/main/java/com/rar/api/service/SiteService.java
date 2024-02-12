package com.rar.api.service;

import com.rar.api.entity.Site;

import java.util.List;

public interface SiteService {
    Site addSite(Site site);

    Site getSiteById(Integer siteId);

    List<Site> getAllSites();

    Site updateSite(Site site);

    Site updateSiteById(Site site);

    void deleteSite(Integer siteId);

}
