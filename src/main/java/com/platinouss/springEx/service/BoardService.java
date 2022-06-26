package com.platinouss.springEx.service;

import com.platinouss.springEx.domain.BoardDto;
import com.platinouss.springEx.domain.SearchCondition;

import java.util.List;

public interface BoardService {
    // 게시물 가져오기
    List<BoardDto> getSearchResultPost(SearchCondition sc) throws Exception;

    // 게시물 총합 개수
    int getSearchResultCnt(SearchCondition sc) throws Exception;

    int writePost(BoardDto boardDto) throws Exception;

    BoardDto readPost(Integer bno) throws Exception;
}
