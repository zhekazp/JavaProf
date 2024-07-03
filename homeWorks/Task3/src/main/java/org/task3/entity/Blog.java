package org.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Blog {
    private int id;
    private String title;
    private int authorId;
    private String content;
    private int views;
    private String date;

    public Blog(String title, int authorId, String content, int views, String date) {
        this.title = title;
        this.authorId = authorId;
        this.content = content;
        this.views = views;
        this.date = date;
    }
}
