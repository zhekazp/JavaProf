package org.task3.repository;

import org.task3.entity.Blog;
import org.task3.entity.BlogComment;

import java.util.List;

public interface BlogCommentRepository {
    public Integer addBlog(BlogComment comment);
    public boolean updateBlog(BlogComment comment);
    public boolean removeBlog(Integer id);
    public List<BlogComment> getCommentsOfBlog(Integer blogId);
}
