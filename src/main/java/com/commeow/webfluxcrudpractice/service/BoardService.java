package com.commeow.webfluxcrudpractice.service;

import com.commeow.webfluxcrudpractice.dto.board.BoardRequestDto;
import com.commeow.webfluxcrudpractice.dto.board.BoardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {
    public Mono<BoardResponseDto> createBoard(BoardRequestDto boardRequestDto);
    public Flux<BoardResponseDto> getAllBoards();
    public Mono<BoardResponseDto> getBoard(String boardId);
    public Mono<BoardResponseDto> updateBoard(BoardRequestDto boardRequestDto, String boardId);
    public Mono<Void> deleteBoard(String boardId);
}
