package com.commeow.webfluxpractice.repository;

import com.commeow.webfluxpractice.entity.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BoardRepository extends ReactiveCrudRepository<Board,String> {
}
