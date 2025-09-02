//chapter entity, each book can have more than 1 chapter, all chapter have i book they owned by
package com.northerners.model;
import org.springframework.stereotype.Component;

@Component 
public class chapter {
    private int bookId;
    private int chapterId;
    private String chapterName;

    public int getChapterId(){
        return chapterId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getText(){
        return text;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}



