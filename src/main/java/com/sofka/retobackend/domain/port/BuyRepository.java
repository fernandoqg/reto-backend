package com.sofka.retobackend.domain.port;

import com.sofka.retobackend.domain.model.Buy;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyRepository extends ReactiveMongoRepository<Buy, String> {
}
