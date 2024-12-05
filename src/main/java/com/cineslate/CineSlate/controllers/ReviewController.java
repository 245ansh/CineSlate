package com.cineslate.CineSlate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cineslate.CineSlate.entities.Review;
import com.cineslate.CineSlate.services.ReviewService;
@RestController
public class ReviewController {
    @Autowired 
    private ReviewService reviewService;

    @GetMapping("/review/{id}")
    public Review getReview(@PathVariable Long id){
        Optional<Review> optionalreview= reviewService.getById(id);
        if(optionalreview.isPresent()){
            return optionalreview.get();
        }
        return null;
    }

    @GetMapping("/reviews")
    public List<Review> getReviews(){
        return reviewService.findAll();
    }
    @PostMapping("/review/add/{id}")
    public Review addReview(@RequestBody  Review review,@PathVariable Long id){
        review.setMovieId(id);
        return reviewService.save(review);
    }
        @PostMapping("/review/edit/{id}")
        public Review updatePost(@RequestBody Review review,@PathVariable Long id){

        Optional<Review> optionalReview = reviewService.getById(id);
        if(optionalReview.isPresent()){
            Review rev = optionalReview.get();
            rev.setDescription(review.getDescription());
            rev.setBody(review.getBody());
            rev.setRating(review.getRating());
            return reviewService.save(rev);
        }
        return null;
    }

    @GetMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable Long id){
        Optional<Review> optionalReview= reviewService.getById(id);
        if(optionalReview.isPresent()){
            Review review= optionalReview.get();
            reviewService.delete(review);
            return "Deletion Successful";
        }
        return "Review not Found";
    }
}
