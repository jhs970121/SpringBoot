package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.NoticeService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private PageService pageService;

    @GetMapping("notice_content/{nid}/{reqPage}")
    public String notice_content(@PathVariable String nid, @PathVariable int reqPage, Model model) {
        model.addAttribute("notice", noticeService.content(nid));
        model.addAttribute("page", reqPage);

        return "/notice/notice_content";
    }


    @GetMapping("notice_list/{page}")
    public String notice_list(@PathVariable String page, Model model) {

        PageDto pageDto = pageService.getPageResult(new PageDto(page, "notice"));

        model.addAttribute("list", noticeService.list(pageDto));
        model.addAttribute("page", pageDto);

        return "/notice/notice_list";
    }
}
