package com.platinouss.springEx.controller;

import com.platinouss.springEx.dao.UserDao;
import com.platinouss.springEx.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserDao userDao;

    @GetMapping("/add")
    public String register() {
        return "registerForm";
    }

    @PostMapping("/add")
    public String save(@Valid UserDto userDto, BindingResult result, Model m) throws Exception {
        System.out.println("result=" + result);
        System.out.println("user=" + userDto);

        try {
            if(result.hasErrors()) {
                throw new Exception("Register Failed");
            }

            int rowCount = userDao.insertUser(userDto);
            if(rowCount == 0) {
                throw new Exception("Register Failed");
            }

            m.addAttribute("msg", "REG_OK");
            return "index";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(userDto);
            m.addAttribute("msg", "REG_ERR");

            return "registerForm";
        }
    }
}
