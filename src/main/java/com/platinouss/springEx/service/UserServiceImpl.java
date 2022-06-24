package com.platinouss.springEx.service;

import com.platinouss.springEx.dao.UserDao;
import com.platinouss.springEx.domain.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    UserDao userDao;

    public UserServiceImpl (UserDao userDao) {
        this.userDao = userDao;
    }

    public int registerUser(UserDto userDto) throws Exception {
        int rowCount = userDao.insertUser(userDto);

        return rowCount;
    }

    public UserDto getUser(String id) throws Exception {
        UserDto userDto = userDao.selectUser(id);

        return userDto;
    }
}
