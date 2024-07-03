package org.task4.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.task4.DTO.UserWithIdDTO;
import org.task4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
   @Query("UPDATE User u set u.name = :#{#user.name}, u.password = :#{#user.password}," +
            "u.email =:#{#user.email}, u.phone = :#{#user.phone} where u.id= :#{#user.id}")
//    @Query("UPDATE User u set u.name = :name where u.id= :id")
//    int updateAllById(@Param("name") String  name, @Param("id") Integer id);
    int updateAllById(@Param("user") UserWithIdDTO user);
}
