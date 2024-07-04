package org.task4.DTO.blog;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogResponseDTO {
    private int id;
    private String title;
    private String content;
    private Integer authorId;
    private String authorName;
    private int views;
    private int comments;
}
