package com.platinouss.springEx.controller;

import com.platinouss.springEx.dao.UserDao;
import com.platinouss.springEx.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserDao userDao;

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, boolean rememberId, RedirectAttributes rattr,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {

        if(!loginCheck(id, pwd)) {
            rattr.addFlashAttribute("loginMsg", "LOGIN_ERR");

            return "redirect:/login/login";
        }

        HttpSession session = request.getSession();
        session.setAttribute("id", id);

        if(rememberId) {
            Cookie cookie = new Cookie("id", id);
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);

            response.addCookie(cookie);
        }

        return "redirect:/";
    }

    private boolean loginCheck(String id, String pwd) {
        UserDto userDto = null;

        try {
            userDto = userDao.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return (userDto != null) && (userDto.getPwd().equals(pwd));
    }
}
