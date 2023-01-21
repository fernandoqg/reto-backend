package com.sofka.retobackend.application.useCases;

import com.sofka.retobackend.domain.model.Product;
import reactor.core.publisher.Mono;

public interface SaveAndDeleteProduct {
    public Mono<Product> save(Product product);

    public Mono<Void> delete(Product product);
}
