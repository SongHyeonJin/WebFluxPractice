package com.commeow.webfluxpractice.service;

import com.commeow.webfluxpractice.dto.board.BoardRequestDto;
import com.commeow.webfluxpractice.dto.board.BoardResponseDto;
import com.commeow.webfluxpractice.entity.Board;
import com.commeow.webfluxpractice.entity.Member;
import com.commeow.webfluxpractice.repository.BoardRepository;
import com.commeow.webfluxpractice.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public Mono<BoardResponseDto> createBoard(BoardRequestDto boardRequestDto) {
        Board board = new Board(boardRequestDto, LocalDateTime.now(),LocalDateTime.now());
        return boardRepository.save(board)
                .map(AppUtils::entityToDto);
    }

    @Override
    public Flux<BoardResponseDto> getAllBoards(String userId) {
        return boardRepository.findAll()
                .flatMap(board -> {
                    if(userId.equals(board.getMember().getUserId()))
                        return boardRepository.findAll();
                    else
                        return Mono.error(new IllegalArgumentException("로그인하그라"));
                })
                .map(AppUtils::entityToDto);
    }

    @Override
    public Mono<BoardResponseDto> getBoard(String boardId) {
        return boardRepository.findById(boardId).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<BoardResponseDto> updateBoard(BoardRequestDto boardRequestDto, String boardId) {
        Mono<Board> boardMono = boardRepository.findById(boardId);
        return boardMono.flatMap((boardUpdate) -> {
            boardUpdate.setTitle(boardRequestDto.getTitle());
            boardUpdate.setContent(boardRequestDto.getContent());
            boardUpdate.setNickname(boardRequestDto.getNickname());
            boardUpdate.setModifiedTime(LocalDateTime.now());
            return boardRepository.save(boardUpdate);
        }).map(AppUtils::entityToDto);
    }

    @Override
    public Mono<Void> deleteBoard(String boardId) {
        return boardRepository.deleteById(boardId);
    }
}
