package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.BoardDto;
import com.platinouss.springEx.domain.SearchCondition;

import java.util.List;

public interface BoardDao {
    int insert(BoardDto boardDto) throws Exception;

    BoardDto select(int bno) throws Exception;

    int count() throws Exception;

    int update(BoardDto boardDto) throws Exception;

    int delete(Integer bno, String writer) throws Exception;

    int deleteAll() throws Exception;

    List<BoardDto> searchSelectPost(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;

    int increaseViewCount(Integer bno) throws Exception;
}
