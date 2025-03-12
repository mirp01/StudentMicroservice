package com.example.studentmicroservice.repository;
import com.example.studentmicroservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByStudentID(String studentID);
}