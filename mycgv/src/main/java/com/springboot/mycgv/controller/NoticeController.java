package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @GetMapping("notice_list")
    public String notice_list(Model model) {
        List<NoticeDto> list = noticeService.list();

        model.addAttribute("list", list);

        return "/notice/notice_list";
    }
}
