package com.commeow.webfluxpractice.repository;

import com.commeow.webfluxpractice.entity.RefreshToken;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface RefreshTokenRepository extends ReactiveCrudRepository<RefreshToken, String> {
    Mono<RefreshToken> findByUserId(String userId);
}
