package org.task3.services.blog;

import org.springframework.stereotype.Service;
import org.task3.entity.Blog;
import org.task3.entity.BlogDTO;
import org.task3.repository.BlogRepository;

@Service
public class AddBlogService {
    BlogRepository blogRepository;

    public AddBlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Integer addBlog(BlogDTO blog){
        Blog newBlog = new Blog(blog.getTitle(), blog.getAuthorId(), blog.getContent(), blog.getViews(), blog.getDate());
        return blogRepository.addBlog(newBlog);
    }
}
