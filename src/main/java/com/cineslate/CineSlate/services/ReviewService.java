package com.cineslate.CineSlate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cineslate.CineSlate.entities.Review;
import com.cineslate.CineSlate.entities.User;
import com.cineslate.CineSlate.repository.ReviewRepository;
import com.cineslate.CineSlate.repository.UserRepository;
@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewrepo;
    @Autowired
    private UserRepository userRepository;
    
    public Review getById(Long id){
        Review rev= reviewrepo.findById(id).get();
        rev.setUser(null);
        return rev;
    }

    public List<Review> findAll(){
        List<Review> list= reviewrepo.findAll();
        for(Review rev:list){
            rev.setUser(null);
        }
        return list;
    }

    public List<Review> findReviewsByUser(User user) {
        List<Review> send= user.getReviews(); 
        return send;
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
