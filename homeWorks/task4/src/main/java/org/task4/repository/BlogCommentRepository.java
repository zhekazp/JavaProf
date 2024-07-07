package org.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task4.entity.BlogComment;
@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer> {
}
