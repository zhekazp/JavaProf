package org.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogDTO {
    private String title;
    private int authorId;
    private String content;
    private int views;
    private String date;
}
