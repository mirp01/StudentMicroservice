package com.example.studentmicroservice.controller;
import com.example.studentmicroservice.model.User;
import com.example.studentmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/students")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{studentID}")
    public ResponseEntity<User> getUserByStudentID(@PathVariable String studentID) {
        Long id = userService.getUserIDByStudentID(studentID);
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }
    @PutMapping("/{studentID}")
    public ResponseEntity<User> updateUser(@PathVariable String studentID, @RequestBody User
            userDetails) {
        User updatedUser = userService.updateUser(studentID, userDetails);
        return updatedUser != null ? ResponseEntity.ok(updatedUser) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{studentID}")
    public ResponseEntity<Void> deleteUser(@PathVariable String studentID) {
        return userService.deleteUser(studentID) ? ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}