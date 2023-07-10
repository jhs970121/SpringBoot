package com.springboot.mycgv.dto;

import lombok.Data;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Data
public class BoardDto {
    private int rno;
    private int bhits;
    private String bid;
    private String btitle;
    private String bcontent;
    private String id;
    private String bdate;
    private String bfile;
    private String bsfile;

    private CommonsMultipartFile file1;
}
