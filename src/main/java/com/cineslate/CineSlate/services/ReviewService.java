package com.cineslate.CineSlate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cineslate.CineSlate.entities.Review;
import com.cineslate.CineSlate.repository.ReviewRepository;
@Service
public class ReviewService {

      @Autowired
    private ReviewRepository reviewrepo;

    public Optional<Review> getById(Long id){
        return reviewrepo.findById(id);
    }

    public List<Review> findAll(){
        return reviewrepo.findAll();
    }

    
    public Page<Review> findAll(int offset, int pageSize, String field){
        return reviewrepo.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
    }
    
    public void delete(Review Review){
        reviewrepo.delete(Review);
    }
    public Review save(Review review){
        if (review.getMovieId()==null){
            return null;
        }
        return reviewrepo.save(review);
    }

}
