package com.commeow.webfluxcrudpractice.repository;

import com.commeow.webfluxcrudpractice.entity.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BoardRepository extends ReactiveCrudRepository<Board,String> {
}
