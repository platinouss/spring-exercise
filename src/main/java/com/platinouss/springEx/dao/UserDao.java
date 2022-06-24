package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.UserDto;

public interface UserDao {
    int insertUser(UserDto userDto) throws Exception;
    UserDto selectUser(String id) throws Exception;
    int deleteAll() throws Exception;
}
