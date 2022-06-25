package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        String writer = "qwer";
        for(int i=1; i<=testValue; i++) {
            BoardDto boardDto = new BoardDto("title" + i, "content" + i, writer);
            boardDao.insert(boardDto);
        }

        assertEquals(testValue, boardDao.count());
    }
}