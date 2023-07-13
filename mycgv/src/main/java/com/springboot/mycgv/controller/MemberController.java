package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.MemberDto;
import com.springboot.mycgv.dto.SessionDto;
import com.springboot.mycgv.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class MemberController {
    @Autowired
    MemberService memberService;

    /* mypage */
    @GetMapping("mypage")
    public String mypage() {

        return "/mypage/mypage";
    }

    /* logout */
    @GetMapping("logout")
    public String logout(HttpSession session, Model model) {
        SessionDto sessionVo = (SessionDto) session.getAttribute("sessionVo"); //형변환이 필요한 이유 : session.getAttribute 의 리턴타입이 Object라서
        if(sessionVo != null) {
            session.invalidate();
            model.addAttribute("logout_result", "ok");
        }
        return "index";
    }
    /* join process*/
    @PostMapping("join")
    public String join_proc(MemberDto memberDto, Model model) {

        log.info("memberDto.getEmail = {}", memberDto.getEmail());
        log.info("memberDto.getPnumber = {}", memberDto.getPnumber());

        if(memberService.join(memberDto) == 1) {
            model.addAttribute("join_result", "ok");
        }

        return "/login/login";
    }

    /* join form */
    @GetMapping("join")
    public String join() {
        return "/join/join";
    }


    /* login process */
    @PostMapping("login")
    public String login_proc(MemberDto memberDto, Model model, HttpSession session) {
        SessionDto sessionDto = memberService.login(memberDto);
        log.info("sessionDto.getId() = {}", sessionDto.getId());

        if(sessionDto.getLoginresult() == 1) {
            session.setAttribute("sessionVo", sessionDto);
            model.addAttribute("login_result","ok");
        }else {
            model.addAttribute("login_result", "fail");
        }
        return "index";
    }

    /* login form */
    @GetMapping("login")
    public String login() {
        return"/login/login";
    }
}
