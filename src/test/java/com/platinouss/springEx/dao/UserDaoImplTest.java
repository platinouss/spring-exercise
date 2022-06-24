package com.platinouss.springEx.dao;

import com.platinouss.springEx.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UserDaoImplTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void insertUserTest() throws Exception {
        userDao.deleteAll();
        UserDto userDto = new UserDto("asdf", "1234", "name", "aaa@aaa.com", new java.sql.Date(2022,3,1));
        assertEquals(1, userDao.insertUser(userDto));

        UserDto resultDto;
        resultDto = userDao.selectUser("asdf");
        assertEquals("asdf", resultDto.getId());
    }
}