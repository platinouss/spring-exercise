package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession session;
    private static String namespace = "com.platinouss.springEx.dao.UserMapper.";

    @Override
    public int insertUser(UserDto userDto) throws Exception {
        return session.insert(namespace + "insert", userDto);
    }

    @Override
    public UserDto selectUser(String id) throws Exception {
        return session.selectOne(namespace + "select", id);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace + "deleteAll");
    }
}
