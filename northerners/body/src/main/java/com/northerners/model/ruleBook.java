package com.northerners.model;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ruleBook {
    private int bookId;
    private float version;
    private String bookName;
    private List<chapter> chapter;

    public int getBookId() {
        return bookId;
    }

    public List<chapter> getChapter() {
        return chapter;
    }

    public String getBookName() {
        return bookName;
    }

    public float getVersion() {
        return version;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setChapter(List<chapter> chapter) {
        this.chapter = chapter;
    }

    public void setVersion(float version) {
        this.version = version;
    }
}
