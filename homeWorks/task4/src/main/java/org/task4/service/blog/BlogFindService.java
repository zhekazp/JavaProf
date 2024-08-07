package org.task4.service.blog;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.entity.Blog;
import org.task4.exeption.NotFoundException;
import org.task4.repository.BlogRepository;
import org.task4.service.util.BlogConverter;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogFindService {
    BlogRepository blogRepository;
    BlogConverter blogConverter;
    public List<BlogResponseDTO> findAll() {
       return blogRepository.findAll().stream().map(blogConverter::fromBlogToResponseDTO).toList();
    }
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElseThrow(()->
                new NotFoundException("Blog not found with id " + id));
    }
}
