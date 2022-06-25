package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.BoardDto;

public interface BoardDao {
    int insert(BoardDto boardDto) throws Exception;

    BoardDto select(int bno) throws Exception;

    int count() throws Exception;

    int update(BoardDto boardDto) throws Exception;

    int delete(Integer bno, String writer) throws Exception;

    int deleteAll() throws Exception;
}
