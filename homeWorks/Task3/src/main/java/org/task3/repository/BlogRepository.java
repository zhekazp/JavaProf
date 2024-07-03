package org.task3.repository;

import org.task3.entity.Blog;

import java.util.List;

public interface BlogRepository {
    public Integer addBlog(Blog blog);
    public boolean updateBlog(Blog blog);
    public boolean removeBlog(Integer id);
    public List<Blog> getAllBlogs();
    public List<Blog> getBlogsByAuthor(Integer authorId);
}
