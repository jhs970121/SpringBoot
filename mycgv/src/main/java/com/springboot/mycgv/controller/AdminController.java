package com.springboot.mycgv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @GetMapping("notice_list")
    public String admin_notice_list() {
        return "admin/notice/admin_notice_list";
    }

    @GetMapping("member_list")
    public String admin_member_list() {
        return "admin/member/admin_member_list";
    }
    /* admin_index */
    @GetMapping("index")
    public String admin_index() {
        return "/admin/admin_index";
    }

}
