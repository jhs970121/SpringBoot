package com.springboot.mycgv.service;

import com.springboot.mycgv.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

@Service
@Slf4j
public class FileUploadService {
    /*
    fileDelete기능 - 기존에 있던 파일 삭제
     */
    public void fileDelete(String oldBsFile) throws Exception {
        String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\";
        File deleteFile = new File(projectPath + oldBsFile);
        if(deleteFile.exists()) {
            deleteFile.delete();
        }
    }

    /**
     * fileSave 기능 - 파일이 존재하면 서버에 저장하는 메소드
     */
    public void fileSave(BoardDto boardDto) throws Exception{
        //파일의 저장위치
        String projectPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\upload\\"; //user.dir -> 프로젝트까지의 경로
        log.info("projectPath -> {}", projectPath);

        //파일이 존재하면 서버에 저장
        if(boardDto.getFile1().getOriginalFilename() != null && !boardDto.getFile1().getOriginalFilename().equals("")) {
            File saveFile = new File(projectPath+ boardDto.getBsfile());
            boardDto.getFile1().transferTo(saveFile); //파일 저장

            log.info("boardDto.getBfile() -> {}", boardDto.getBfile());
        }
    }

    /**
     * fileCheck 기능 - 파일이 존재하면 boardVo에 bfile, bsfile set!, 없으면 boardDto
     */
    public Object fileCheck(BoardDto boardDto) {

        if(boardDto.getFile1().getOriginalFilename() != null
                && !boardDto.getFile1().getOriginalFilename().equals("")) { //File O

            //BSFILE 파일 중복 처리
            UUID uuid = UUID.randomUUID();
            String bfile = boardDto.getFile1().getOriginalFilename();
            String bsfile = uuid +"_"+ bfile;

            boardDto.setBfile(bfile);
            boardDto.setBsfile(bsfile);

        }else {
            System.out.println("파일 없음");
        }

        return boardDto;
    }
}
