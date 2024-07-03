package org.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogComment {
    private int id;
    private int authorId;
    private String text;
    private int blogId;

    public BlogComment(int authorId, String text, int blogId) {
        this.authorId = authorId;
        this.text = text;
        this.blogId = blogId;
    }
}

