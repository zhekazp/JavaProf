package org.task4.service.blogComment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.task4.DTO.blogComment.BlCommentRequestDTO;
import org.task4.entity.Blog;
import org.task4.entity.BlogComment;
import org.task4.entity.User;
import org.task4.repository.BlogCommentRepository;
import org.task4.service.blog.BlogFindService;
import org.task4.service.blog.BlogUpdateService;
import org.task4.service.user.UserFindService;

@Service
@AllArgsConstructor
public class BlogCommentAddService {
    private final UserFindService userFindService;
    private final BlogFindService blogFindService;
    private final BlogCommentRepository commentBlogRepository;
    private final BlogUpdateService blogUpdateService;

    public String addCommentBlog(BlCommentRequestDTO requestDTO) {
        User user = userFindService.findUserById(requestDTO.getAuthorId());
        Blog blog = blogFindService.findById(requestDTO.getBlogId());
        Integer id = commentBlogRepository.save(new BlogComment(requestDTO.getComment(), user, blog)).getId();
        blogUpdateService.increaseComments(blog.getId());
        return "{\"blogCommentId\" : " + id+"}";
    }
}
