package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.BoardService;
import com.springboot.mycgv.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
    @Autowired
    PageService pageService;
    @Autowired
    BoardService boardService;

    @GetMapping("board_update/{bid}")
    public String board_update(@PathVariable String bid, Model model) {

        return "/board/board_update";
    }

    @GetMapping("board_content/{bid}/{reqPage}")
    public String board_content(@PathVariable String bid, @PathVariable String reqPage, Model model) {

        model.addAttribute("bvo", boardService.content(bid));
        model.addAttribute("page", reqPage);

        return "/board/board_content";
    }

    @GetMapping("board_list/{page}")
    public String board_list(@PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "board"));

        model.addAttribute("page", pageDto);
        model.addAttribute("board", boardService.list(pageDto));


        return "/board/board_list";
    }
}
