package org.task4.service.blog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.task4.DTO.blog.BlogDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.entity.Blog;
import org.task4.entity.User;
import org.task4.repository.BlogRepository;
import org.task4.service.user.AddUserService;
import org.task4.service.user.FindUserService;
import org.task4.service.util.BlogConverter;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class BlogAddService {
    BlogRepository blogRepository;
    FindUserService findUserService;
    BlogConverter blogConverter;

    public Optional<BlogResponseDTO> addBlog(BlogDTO blog){
        Optional<User> user = findUserService.findUserById(blog.getAuthorId());
               if (user.isPresent()) {
            Blog newBlog = blogConverter.fromRequesDTOToBlog(blog, user.get());
            return  Optional.of(blogConverter.fromBlogToResponseDTO(blogRepository.saveAndFlush(newBlog)));
        }
        return Optional.empty();
    }
}
