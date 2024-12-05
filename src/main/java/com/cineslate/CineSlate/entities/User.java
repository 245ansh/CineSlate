package com.cineslate.CineSlate.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String username;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender; 
  
    private LocalDate DOB;
    private String photo;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    
    @OneToMany(mappedBy = "user")
    private List<Lists> lists;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
