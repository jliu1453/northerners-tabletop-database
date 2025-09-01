package com.northerners.controller;

import com.northerners.model.chapter;
import com.northerners.service.impl.chapterService;
import com.northerners.service.impl.ruleBookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class chapterController {
    private final chapterService chapterService;
    public chapterController(chapterService chapterService){
        this.chapterService = chapterService;
    }

    @GetMapping("/{chapterId}")
    public chapter getChapterById(@PathVariable int chapterId){ return chapterService.getChapterById(chapterId);}

    @GetMapping
    public List<chapter> getAllChapters(){return chapterService.findAllChapter();}


    @PutMapping("/{chapterId}")
    public ResponseEntity<Integer> updateChapter(@PathVariable int chapterId, @RequestBody chapter chapter){
        int result = 0;
        if(chapter.getChapterId() != chapterId){
            return ResponseEntity.badRequest().build();
        }
        result = chapterService.updateChapter(chapter);
        if(result == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{chapterId}")
    public ResponseEntity<Integer> deleteChapter(@PathVariable int chapterId){
        chapter temp = chapterService.getChapterById(chapterId);
        if(temp == null){
            return ResponseEntity.notFound().build();
        }
        chapterService.deleteChapter(temp);
        return ResponseEntity.noContent().build();
    }


}
