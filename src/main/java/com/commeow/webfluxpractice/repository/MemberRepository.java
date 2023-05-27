package com.commeow.webfluxpractice.repository;

import com.commeow.webfluxpractice.entity.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
    Mono<Member> findByUserId(String userId);
}
