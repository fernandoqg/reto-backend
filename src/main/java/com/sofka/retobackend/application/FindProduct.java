package com.sofka.retobackend.application;

import com.sofka.retobackend.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FindProduct {

    public Flux<Product> findAll();

    public Mono<Product> FindById(String id);
}
