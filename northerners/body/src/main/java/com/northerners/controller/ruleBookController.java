package com.northerners.controller;

import com.northerners.model.chapter;
import com.northerners.model.ruleBook;
import com.northerners.model.user;
import com.northerners.service.impl.chapterService;
import com.northerners.service.impl.ruleBookService;
import com.northerners.service.impl.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ruleBook")
public class ruleBookController {
    private final ruleBookService ruleBookService;
    private final chapterService chapterService;
    public ruleBookController(ruleBookService ruleBookService, chapterService chapterService){
        this.ruleBookService = ruleBookService;
        this.chapterService = chapterService;
    }

    @RequestMapping("{bookId}")
    public ruleBook getRuleBookById(@PathVariable int bookId){
        return ruleBookService.findBookById(bookId);
    }

    @GetMapping
    public List<ruleBook> getAllRuleBook(){
        return ruleBookService.findAllRuleBook();
    }


    @GetMapping("/{bookId}/chapter")
    public List<chapter> getChapterFromBook(@PathVariable int bookId){
        return chapterService.getChapterByBook(bookId);
    }

    @PostMapping("{bookId}/chapter")
    public ResponseEntity<chapter> insertChapterToBook(@RequestBody chapter chapter, @PathVariable int bookId){
        if(chapter.getBookId() != bookId) {
            return ResponseEntity.badRequest().build();
        }
        chapter temp = new chapter();
        if(chapterService.createChapter(chapter) == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(chapter);
    }

    @PostMapping
    public ResponseEntity<ruleBook> insertRuleBook(@RequestBody ruleBook ruleBook) {
        int result = ruleBookService.createRuleBook(ruleBook);

        if (result != 0) {
            // At this point, ruleBook.getBookId() should already be populated
            return ResponseEntity.status(HttpStatus.CREATED).body(ruleBook);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Integer> updateRuleBook(@PathVariable int bookId, @RequestBody ruleBook ruleBook){
        int result = 0;
        if(ruleBook.getBookId() != bookId){
            return ResponseEntity.badRequest().build();
        }
        result = ruleBookService.updateRuleBook(ruleBook);
        if(result == 0){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(result);
        }
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Integer> deleteRuleBook(@PathVariable int bookId){
        ruleBook temp = ruleBookService.findBookById(bookId);
        if(temp == null){
            return ResponseEntity.notFound().build();
        }
        ruleBookService.deleteRuleBook(temp);
        return ResponseEntity.noContent().build();
    }
}
