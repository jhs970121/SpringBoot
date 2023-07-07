package com.springboot.mycgv.service;

import com.springboot.mycgv.dto.NoticeDto;
import com.springboot.mycgv.repository.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    public List<NoticeDto> list() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("start", "1");
        param.put("end", "5");

        return noticeMapper.list(param);
    }
}
