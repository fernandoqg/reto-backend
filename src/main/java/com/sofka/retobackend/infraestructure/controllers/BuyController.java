package com.sofka.retobackend.infraestructure.controllers;

import com.sofka.retobackend.application.SaveAndDeleteBuy;
import com.sofka.retobackend.domain.model.Buy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("api/buys")
public class BuyController {

    @Autowired
    private SaveAndDeleteBuy serviceBuy;

    @PostMapping
    public Mono<ResponseEntity<Buy>> create(@RequestBody Buy buy){
        return serviceBuy.save(buy)
                .map(p -> ResponseEntity
                        .created(URI.create("/api/buys/".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p));
    }
}
