package com.commeow.webfluxcrudpractice.repository;

import com.commeow.webfluxcrudpractice.entity.Member;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MemberRepository extends ReactiveCrudRepository<Member, String> {
}
