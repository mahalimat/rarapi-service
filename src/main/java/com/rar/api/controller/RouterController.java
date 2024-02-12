package com.rar.api.controller;

import com.rar.api.entity.Router;
import com.rar.api.service.RouterService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RequestMapping("api/router")
public class RouterController {

    private RouterService routerService;

    @PostMapping
    public ResponseEntity<Router> addRouter(@RequestBody Router router) {
        return new ResponseEntity<>(routerService.addRouter(router), HttpStatus.CREATED);
    }

    // http://localhost:8081/api/router/1
    @GetMapping("{id}")
    public  ResponseEntity<Router> getRouterById(@PathVariable("id") Integer routerId) {
        Router router = routerService.getRouterById(routerId);
        return new ResponseEntity<>(router, HttpStatus.OK);
    }

    // http://localhost:8081/api/router/all
    @GetMapping("all")
    public ResponseEntity<List<Router>> getAllRouters() {
        List<Router> routers = routerService.getAllRouters();
        return new ResponseEntity<>(routers, HttpStatus.OK);
    }

    // http://localhost:8081/api/router/
    @PatchMapping
    public ResponseEntity<Router> updateRouter(@RequestBody Router router) {
        Router updatedRouter = routerService.updateRouter(router);

        return  new ResponseEntity<>(updatedRouter, HttpStatus.OK);
    }

    // http://localhost:8081/api/router/1
    @PutMapping("{id}")
    public ResponseEntity<Router> updateRouterById(@PathVariable("id") Integer routerId,
                                               @RequestBody Router router) {
        router.setRouterId(routerId);
        Router updatedRouter = routerService.updateRouter(router);

        return  new ResponseEntity<>(updatedRouter, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRouter(@PathVariable("id") Integer routerId) {
        routerService.deleteRouter(routerId);

        return new ResponseEntity<>("Router successfully deleted!!!", HttpStatus.OK);
    }
}
