//service for rulebook
package com.northerners.service.impl;

import com.northerners.mapper.impl.chapterMapper;
import com.northerners.mapper.impl.ruleBookMapper;
import com.northerners.model.chapter;
import com.northerners.model.ruleBook;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ruleBookService {
    private final ruleBookMapper ruleBookMapper;
    private final chapterMapper chapterMapper;

    public ruleBookService(ruleBookMapper ruleBookMapper, chapterMapper chapterMapper)
    {
        this.ruleBookMapper = ruleBookMapper;
        this.chapterMapper = chapterMapper;
    }

    public List<ruleBook> findAllRuleBook(){
        List<ruleBook> books = ruleBookMapper.findAll();
        for (ruleBook book : books) {
            List<chapter> chapters = chapterMapper.findByBookId(book.getBookId());
            book.setChapter(chapters);
        }
        return books;
    }

    public ruleBook findBookById(int id){
        ruleBook books = ruleBookMapper.findById(id);
        books.setChapter(chapterMapper.findByBookId(id));
        return books;
    }

    public ruleBook findByBookName(String name){return ruleBookMapper.findByBookName(name);}

    public int createRuleBook(ruleBook ruleBook){
        if(ruleBookMapper.findByBookName(ruleBook.getBookName()) != null){
            return 0;
        }
        else{
            return ruleBookMapper.insert(ruleBook);
        }
    }

    public int updateRuleBook(ruleBook ruleBook){
        if(ruleBookMapper.findById(ruleBook.getBookId()) != null){
            return ruleBookMapper.update(ruleBook);
        }
        else{
            return 0;
        }
    }

    public int deleteRuleBook(ruleBook ruleBook){
        return ruleBookMapper.delete(ruleBook.getBookId());
    }

}

