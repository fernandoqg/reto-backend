package com.sofka.retobackend.application.useCases;

import com.sofka.retobackend.application.FindProduct;
import com.sofka.retobackend.domain.model.Product;
import com.sofka.retobackend.domain.port.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UseCaseFindProduct implements FindProduct {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> FindById(String id) {
        return productRepository.findById(id);
    }
}
