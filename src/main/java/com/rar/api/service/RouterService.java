package com.rar.api.service;

import com.rar.api.entity.Router;

import java.util.List;

public interface RouterService {
     Router addRouter(Router router);

     List<Router> getAllRouters();

     Router getRouterById(Integer id);

     Router updateRouter(Router router);

     Router updateRouterById(Router router);

     void deleteRouter(Integer routerId);


}
