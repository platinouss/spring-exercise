package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.BoardDto;
import com.platinouss.springEx.domain.SearchCondition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDaoImplTest {
    @Autowired
    private BoardDao boardDao;

    @Test
    public void insertPostTest() throws Exception {
        boardDao.deleteAll();
        int testValue = 20;
        String writer = "asdf";
        for(int i=1; i<=testValue; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "content" + i, writer + i);
            boardDao.insert(boardDto);
        }

        assertEquals(testValue, boardDao.count());
    }

    @Test
    // 게시물 검색기능 테스트
    public void searchSelectPostTest() throws Exception {
        insertPostTest();

        // title로 검색
        SearchCondition sc = new SearchCondition(1, 10, "title2", "T");
        List<BoardDto> list = boardDao.searchSelectPost(sc);

        // titile2, title20으로 2개
        assertEquals(2, list.size());

        // writer로 검색
        sc = new SearchCondition(1, 10, "asdf2", "W");
        list = boardDao.searchSelectPost(sc);

        // asdf2, asdf20으로 2개
        assertEquals(2, list.size());
    }
}