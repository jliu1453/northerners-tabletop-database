package com.northerners.mapper.impl;

import com.northerners.mapper.repo;
import com.northerners.model.chapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface chapterMapper extends repo<chapter, Integer> {
    List<chapter> findByBookId(int id);
    chapter findByChapterName(String name);
}
