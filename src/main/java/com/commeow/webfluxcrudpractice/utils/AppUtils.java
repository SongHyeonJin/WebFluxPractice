package com.commeow.webfluxcrudpractice.utils;

import com.commeow.webfluxcrudpractice.dto.board.BoardResponseDto;
import com.commeow.webfluxcrudpractice.dto.member.MemberResponseDto;
import com.commeow.webfluxcrudpractice.entity.Board;
import com.commeow.webfluxcrudpractice.entity.Member;

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
