package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.BoardDto;
import com.platinouss.springEx.domain.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.platinouss.springEx.dao.boardMapper.";

    @Override
    public int insert(BoardDto boardDto) throws Exception {
        return session.insert(namespace + "insert", boardDto);
    }

    @Override
    public BoardDto select(int bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "listcount");
    }

    @Override
    public int update(BoardDto boardDto) throws Exception {
        return session.update(namespace + "update", boardDto);
    }

    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map m = new HashMap();
        m.put("bno", bno);
        m.put("writer", writer);

        return session.delete(namespace + "delete", m);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public List<BoardDto> searchSelectPost(SearchCondition sc) throws Exception {
        return session.selectList(namespace + "searchSelectPost", sc);
    }

    @Override
    public int searchResultCnt(SearchCondition sc) throws Exception {
        return session.selectOne(namespace + "searchResultCnt", sc);
    }
}
