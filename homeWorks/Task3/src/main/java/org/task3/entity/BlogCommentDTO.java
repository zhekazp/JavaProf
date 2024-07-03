package org.task3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BlogCommentDTO {
    private int authorId;
    private String text;
    private int blogId;
}
