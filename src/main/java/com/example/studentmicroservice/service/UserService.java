package com.example.studentmicroservice.service;
import com.example.studentmicroservice.model.User;
import com.example.studentmicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserByStudentID(String studentID) {
        return userRepository.findByStudentID(studentID).orElse(null);
    }
    public Long getUserIDByStudentID(String studentID) {
        return userRepository.findByStudentID(studentID).map(User::getId).orElse(null);
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(String studentID, User userDetails) {
        Long id = getUserIDByStudentID(studentID);
        return userRepository.findById(id).map(user -> {
            user.setFirstname(userDetails.getFirstname());
            user.setLastname(userDetails.getLastname());
            user.setEmail(userDetails.getEmail());
            user.setStudentID(userDetails.getStudentID());
            return userRepository.save(user);
        }).orElse(null);
    }
    public boolean deleteUser(String studentID) {
        Long id = getUserIDByStudentID(studentID);
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}