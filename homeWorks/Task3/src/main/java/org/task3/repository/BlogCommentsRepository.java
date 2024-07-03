package org.task3.repository;

import org.springframework.stereotype.Repository;
import org.task3.entity.Blog;
import org.task3.entity.BlogComment;

import java.util.HashMap;
import java.util.List;

@Repository
public class BlogCommentsRepository implements BlogCommentRepository{
    HashMap<Integer , BlogComment> blogComments = new HashMap<>();
    Integer currentId = 0;
    @Override
    public Integer addBlog(BlogComment comment) {
        comment.setId(++currentId);
        blogComments.put(currentId, comment);
        return currentId;
    }

    @Override
    public boolean updateBlog(BlogComment comment) {
        if(blogComments.get(comment.getId()) != null) {
            blogComments.put(comment.getId(), comment);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeBlog(Integer id) {
        return blogComments.remove(id) != null;
    }

    @Override
    public List<BlogComment> getCommentsOfBlog(Integer blogId) {
        return blogComments.values().stream().filter(comment -> comment.getBlogId() == blogId).toList();
    }
}
