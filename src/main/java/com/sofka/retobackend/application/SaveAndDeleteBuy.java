package com.sofka.retobackend.application;

import com.sofka.retobackend.domain.model.Buy;
import com.sofka.retobackend.domain.model.Product;
import reactor.core.publisher.Mono;

public interface SaveAndDeleteBuy {

    public Mono<Buy> save(Buy buy);

    public Mono<Void> delete(Buy buy);
}
