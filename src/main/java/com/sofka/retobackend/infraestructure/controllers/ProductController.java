package com.sofka.retobackend.infraestructure.controllers;

import com.sofka.retobackend.application.useCases.FindProduct;
import com.sofka.retobackend.application.useCases.SaveAndDeleteProduct;
import com.sofka.retobackend.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private FindProduct serviceFindAll;
    @Autowired
    private SaveAndDeleteProduct serviceSave;

    @GetMapping()
    public Mono<ResponseEntity<Flux<Product>>> findAll(){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(serviceFindAll.findAll()))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>> byId(@PathVariable String id){
        return serviceFindAll.FindById(id)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Mono<ResponseEntity<Product>> create(@RequestBody Product product){
        return serviceSave.save(product)
                .map(p -> ResponseEntity
                        .created(URI.create("/api/products/".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p));
    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<Product>> edit(@RequestBody Product product, @PathVariable String id){
        return serviceFindAll.FindById(id).flatMap(p -> {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            p.setInInventory(product.getInInventory());
            p.setEnable(product.isEnable());
            p.setMax(product.getMax());
            p.setMin(product.getMin());
            return serviceSave.save(p);
        }).map(p -> ResponseEntity.created(URI.create("/api/product".concat(p.getId())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable String id){
        return serviceFindAll.FindById(id).flatMap(p -> {
            return serviceSave.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

}
