package com.sofka.retobackend.application.useCases;

import com.sofka.retobackend.domain.model.Product;
import com.sofka.retobackend.domain.port.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseSaveAndDeleteProduct implements SaveAndDeleteProduct {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Mono<Product> save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public Mono<Void> delete(Product product) {
        return productRepository.delete(product);
    }
}
