package com.example.webservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    @Query(value = "SELECT users.name, COUNT(posts.id) FROM users " +
                   "INNER JOIN posts ON users.id = posts.user_id " +
                   "GROUP BY users.id " +
                   "HAVING COUNT(posts.id) < 10",
           nativeQuery = true)
    List<Object[]> getUsersWithPostCountLessThanTen();
}
