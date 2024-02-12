package com.rar.api.service.impl;

import com.rar.api.entity.Router;
import com.rar.api.repository.RouterRepository;
import com.rar.api.service.RouterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RouterServiceImpl implements RouterService {

    private  RouterRepository routerRepository;
    @Override
    public Router addRouter(Router router) {

        Router addedRouter = routerRepository.saveAndFlush(router);

        return addedRouter;
    }

    @Override
    public List<Router> getAllRouters() {
        return routerRepository.findAll();
    }

    @Override
    public Router getRouterById(Integer id) {
        return routerRepository.findById(id).get();
    }

    @Override
    public Router updateRouter(Router router) {
        return routerRepository.save(router);
    }

    @Override
    public Router updateRouterById(Router router) {
        Router existingRouter = routerRepository.findById(router.getRouterId()).get();
        existingRouter.setRouterName(router.getRouterName());
        existingRouter.setIpAddress(router.getIpAddress());
        existingRouter.setSite(router.getSite());

        Router updatedRouter = routerRepository.save(existingRouter);

        return updatedRouter;
    }

    @Override
    public void deleteRouter(Integer routerId) {
        routerRepository.deleteById(routerId);
    }
}
