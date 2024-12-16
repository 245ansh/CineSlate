package com.cineslate.CineSlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cineslate.CineSlate.entities.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{
}