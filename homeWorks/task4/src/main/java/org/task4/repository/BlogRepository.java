package org.task4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.task4.entity.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
