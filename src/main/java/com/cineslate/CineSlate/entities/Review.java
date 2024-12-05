package com.cineslate.CineSlate.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private Long movieId;
    private String description;
    private String body;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "userId",nullable =true)
    private User user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", movieId=" + movieId + ", description=" + description + ", body="
                + body + ", rating=" + rating + ", userid=" + user + ", createdAt=" + createdAt + ", updatedAt="
                + updatedAt + "]";
    }
    
}
