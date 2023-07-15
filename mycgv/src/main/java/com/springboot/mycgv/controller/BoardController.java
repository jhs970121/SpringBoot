package com.springboot.mycgv.controller;

import com.springboot.mycgv.dto.BoardDto;
import com.springboot.mycgv.dto.PageDto;
import com.springboot.mycgv.service.BoardService;
import com.springboot.mycgv.service.FileUploadService;
import com.springboot.mycgv.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    PageService pageService;

    @Autowired
    BoardService boardService;

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("board_list_json")
    public String board_list_json() {
        return "/board/board_list_json";
    }


    @PostMapping("board_delete")
    public String board_delete_proc(BoardDto boardDto) throws Exception {
        //파일 포함 O
        String oldBsFile = boardService.getBsfile(boardDto.getBid());
        int result = boardService.delete(boardDto.getBid());
        if(result == 1) {
            if(oldBsFile != null) {
                fileUploadService.fileDelete(oldBsFile);
            }
        }
        return "redirect:/board_list/"+boardDto.getPage()+"/";
    }

    @GetMapping("board_delete/{bid}/{reqPage}")
    public String board_delete(@PathVariable String bid, @PathVariable String reqPage, Model model) {
        model.addAttribute("bid", bid);
        model.addAttribute("page", reqPage);
        return "/board/board_delete";
    }

    @PostMapping("board_update")
    public String board_update_proc(BoardDto boardDto, RedirectAttributes redirectAttributes) throws Exception {
        //새로운 파일 선택시 기존파일(oldFileName:bsfile) 삭제
        String oldBsFile = boardDto.getBsfile(); //기존에 업로드 됐었던 Bsfile
        log.info("oldBsFile -> {}", oldBsFile);
        log.info("bfile -> {}", boardDto.getBfile());
        log.info("bsfile -> {}", boardDto.getBsfile());
        boardDto = (BoardDto)fileUploadService.fileCheck(boardDto); // 수정 완료 클릭 후 새로 업로드 하는 Bsfile 할당



        int result = boardService.update(boardDto);

        if(result == 1) {
            if(!boardDto.getFile1().isEmpty()) {
                fileUploadService.fileSave(boardDto); //새로운 파일 저장
                fileUploadService.fileDelete(oldBsFile); //기존파일 삭제
            }
            redirectAttributes.addFlashAttribute("update_comp", "ok");
        }
        return "redirect:/board_list/" + boardDto.getPage();
    }

    @GetMapping("board_update/{bid}/{reqPage}")
    public String board_update(@PathVariable String bid, @PathVariable String reqPage, Model model) {

        model.addAttribute("board", boardService.content(bid));
        model.addAttribute("page", reqPage);

        return "/board/board_update";
    }

    @PostMapping("board_write")
    public String board_write_proc(BoardDto boardDto) throws Exception{
        boardDto = (BoardDto)fileUploadService.fileCheck(boardDto);

        int result = boardService.insert(boardDto);

        if(result == 1) {
            fileUploadService.fileSave(boardDto);
        }

        return "redirect:/board_list/1/";
    }

    @GetMapping("board_write")
    public String board_write() {
        return "/board/board_write";
    }



    @GetMapping("board_content/{bid}/{reqPage}")
    public String board_content(@PathVariable String bid, @PathVariable String reqPage, Model model) {

        model.addAttribute("board", boardService.content(bid));
        model.addAttribute("page", reqPage);

        return "/board/board_content";
    }

    @GetMapping("board_list/{page}")
    public String board_list(@PathVariable String page, Model model) {
        PageDto pageDto = pageService.getPageResult(new PageDto(page, "board"));

        model.addAttribute("board", boardService.list(pageDto));
        model.addAttribute("page", pageDto);

        return "/board/board_list";
    }
}
