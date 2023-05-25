package com.commeow.webfluxpractice.utils;

import com.commeow.webfluxpractice.dto.board.BoardResponseDto;
import com.commeow.webfluxpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxpractice.entity.Board;
import com.commeow.webfluxpractice.entity.Member;

public class AppUtils {

    public static BoardResponseDto entityToDto(Board board) {
        return new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getNickname(),
                board.getCurrentTime(),
                board.getModifiedTime()
        );
    }

    public static Board dtoToEntity(BoardResponseDto boardResponseDto) {
        return new Board(
                boardResponseDto.getId(),
                boardResponseDto.getTitle(),
                boardResponseDto.getContent(),
                boardResponseDto.getNickname(),
                boardResponseDto.getCurrentTime(),
                boardResponseDto.getModifiedTime()
        );
    }

    public static MemberResponseDto entityToDtoM(Member member) {
        return new MemberResponseDto(
                member.getId(),
                member.getUserId(),
                member.getNickname(),
                member.getCurrentTime()
        );
    }
}
