package com.example.studentmicroservice.model;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "students")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String studentID;
}