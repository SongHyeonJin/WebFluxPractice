package com.commeow.webfluxpractice.service;

import com.commeow.webfluxpractice.dto.board.BoardRequestDto;
import com.commeow.webfluxpractice.dto.board.BoardResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {
    public Mono<BoardResponseDto> createBoard(BoardRequestDto boardRequestDto);
    public Flux<BoardResponseDto> getAllBoards(String userId);
    public Mono<BoardResponseDto> getBoard(String boardId);
    public Mono<BoardResponseDto> updateBoard(BoardRequestDto boardRequestDto, String boardId);
    public Mono<Void> deleteBoard(String boardId);
}
