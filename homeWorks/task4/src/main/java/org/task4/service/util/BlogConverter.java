package org.task4.service.util;

import org.springframework.stereotype.Service;
import org.task4.DTO.blog.BlogRequestDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.entity.Blog;
import org.task4.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class BlogConverter {
    public BlogResponseDTO fromBlogToResponseDTO(Blog blog) {
        return new BlogResponseDTO(blog.getId(), blog.getTitle(), blog.getContent());
    }
    public Blog fromRequesDTOToBlog(BlogRequestDTO blogDTO, User user) {
        return new Blog(blogDTO.getTitle(), blogDTO.getContent(), user, 0,0);
    }
}
