package org.task4.service.util;

import org.springframework.stereotype.Service;
import org.task4.DTO.blog.BlogDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.entity.Blog;
import org.task4.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BlogConverter {
    public BlogResponseDTO fromBlogToResponseDTO(Blog blog) {
        return new BlogResponseDTO(blog.getId(), blog.getTitle(), blog.getContent(), blog.getAuthor().getId(), blog.getAuthor().getName(), blog.getViews(),blog.getComments());
    }
    public Blog fromRequesDTOToBlog(BlogDTO blogDTO, User user) {
        return new Blog(blogDTO.getTitle(), blogDTO.getContent(), user, LocalDate.now(), LocalDateTime.now(),0,0);
    }
}
