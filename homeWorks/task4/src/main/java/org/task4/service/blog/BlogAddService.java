package org.task4.service.blog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task4.DTO.blog.BlogRequestDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.entity.Blog;
import org.task4.entity.User;
import org.task4.repository.BlogRepository;
import org.task4.service.user.UserFindService;
import org.task4.service.util.BlogConverter;

@Service
@AllArgsConstructor
public class BlogAddService {
    BlogRepository blogRepository;
    UserFindService userFindService;
    BlogConverter blogConverter;

    public BlogResponseDTO addBlog(BlogRequestDTO blog) {
        User user = userFindService.findUserById(blog.getAuthorId());
        Blog newBlog = blogConverter.fromRequesDTOToBlog(blog, user);
        return blogConverter.fromBlogToResponseDTO(blogRepository.save(newBlog));
    }
}
