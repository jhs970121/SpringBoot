package com.springboot.mycgv.repository;

import com.springboot.mycgv.dto.NoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticeMapper {
    List<NoticeDto> list(Map param);
}
