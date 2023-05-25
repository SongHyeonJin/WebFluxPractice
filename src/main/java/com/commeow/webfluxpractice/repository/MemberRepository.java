package com.commeow.webfluxpractice.repository;

import com.commeow.webfluxpractice.entity.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
}
