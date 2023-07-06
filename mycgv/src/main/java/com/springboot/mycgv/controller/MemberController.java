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

@Controller
@Slf4j
public class MemberController {
    @Autowired
    MemberService memberService;

    /* login_proc */
    @PostMapping("login")
    public String login_proc(MemberDto memberDto, Model model) {
        SessionDto sessionDto = memberService.login(memberDto);
        log.info("sessionDto.getName() = {}", sessionDto.getName());

        if(sessionDto.getLoginresult() == 1) {
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
