package org.task3.repository;

import org.springframework.stereotype.Repository;
import org.task3.entity.Blog;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogsRepository implements  BlogRepository{
    HashMap<Integer , Blog> blogs = new HashMap<>();
    Integer currentId = 0;
    @Override
    public Integer addBlog(Blog blog) {
        blog.setId(++currentId);
        blogs.put(currentId, blog);
        return currentId;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        if(blogs.get(blog.getId()) != null) {
            blogs.put(blog.getId(), blog);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBlog(Integer id) {
        return blogs.remove(id) != null;
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogs.values().stream().toList();
    }

    @Override
    public List<Blog> getBlogsByAuthor(Integer authorId) {
        return blogs.values().stream().filter(blog -> blog.getAuthorId() == authorId).toList();
    }

}
