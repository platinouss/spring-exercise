package com.platinouss.springEx.service;

import com.platinouss.springEx.dao.BoardDao;
import com.platinouss.springEx.domain.BoardDto;
import com.platinouss.springEx.domain.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    // 게시물 가져오기
    @Override
    public List<BoardDto> getSearchResultPost(SearchCondition sc) throws Exception {
        return boardDao.searchSelectPost(sc);
    }

    // 게시물 총합 개수
    @Override
    public int getSearchResultCnt(SearchCondition sc) throws Exception {
        return boardDao.searchResultCnt(sc);
    }

    @Override
    public int writePost(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }

    @Override
    public BoardDto readPost(Integer bno) throws Exception {
        BoardDto boardDto = boardDao.select(bno);
        boardDao.increaseViewCount(bno);

        return boardDto;
    }
}
