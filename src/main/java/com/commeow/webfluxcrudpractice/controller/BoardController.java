package com.commeow.webfluxcrudpractice.controller;

import com.commeow.webfluxcrudpractice.dto.board.BoardRequestDto;
import com.commeow.webfluxcrudpractice.dto.board.BoardResponseDto;
import com.commeow.webfluxcrudpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Flux<BoardResponseDto> getAllBoards(){
        return boardService.getAllBoards();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<BoardResponseDto> createBoard(@RequestBody BoardRequestDto boardRequestDto){
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping("/{id}")
    public Mono<BoardResponseDto> getBoard(@PathVariable("id") String boardId){
        return boardService.getBoard(boardId);
    }

    @PutMapping("/{id}")
    public Mono<BoardResponseDto> updateBoard(@PathVariable("id") String boardId,
                                              @RequestBody BoardRequestDto boardRequestDto){
        return boardService.updateBoard(boardRequestDto, boardId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBoard(@PathVariable("id") String boardId){
        return boardService.deleteBoard(boardId);
    }
}
