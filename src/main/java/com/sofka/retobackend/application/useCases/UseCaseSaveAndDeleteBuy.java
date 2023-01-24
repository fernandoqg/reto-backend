package com.sofka.retobackend.application.useCases;

import com.sofka.retobackend.application.SaveAndDeleteBuy;
import com.sofka.retobackend.domain.model.Buy;
import com.sofka.retobackend.domain.port.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseSaveAndDeleteBuy implements SaveAndDeleteBuy {

    @Autowired
    private BuyRepository buyRepository;

    @Override
    public Mono<Buy> save(Buy buy) {
        return buyRepository.save(buy);
    }

    @Override
    public Mono<Void> delete(Buy buy) {
        return buyRepository.delete(buy);
    }

}
