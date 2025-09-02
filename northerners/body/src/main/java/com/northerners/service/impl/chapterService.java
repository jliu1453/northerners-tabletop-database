//service for chapter entity
package com.northerners.service.impl;

import com.northerners.mapper.impl.chapterMapper;
import com.northerners.model.chapter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class chapterService {
    private final chapterMapper chapterMapper;

    public chapterService(chapterMapper chapterMapper){this.chapterMapper = chapterMapper;}

    public List<chapter> findAllChapter(){return chapterMapper.findAll();}

    public chapter getChapterById(int id){return chapterMapper.findById(id);}

    public List<chapter> getChapterByBook(int bookId){return chapterMapper.findByBookId(bookId);}


    public int createChapter(chapter chapter){
        if(chapterMapper.findByChapterName(chapter.getChapterName()) != null){ //check if already exist
            return 0;
        }
        else{
            return chapterMapper.insert(chapter);
        }
    }

    public int updateChapter(chapter chapter){
        if(chapterMapper.findById(chapter.getChapterId()) != null){
           return chapterMapper.update(chapter);
        }
        else{
            return 0;
        }
    }

    public int deleteChapter(chapter chapter){
        return chapterMapper.delete(chapter.getChapterId());
    }
}

