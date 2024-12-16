package com.cineslate.CineSlate.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cineslate.CineSlate.entities.Review;
import com.cineslate.CineSlate.entities.User;
import com.cineslate.CineSlate.services.ReviewService;
import com.cineslate.CineSlate.services.UserService;

@Controller
public class ReviewController {
    @Autowired
    private UserService userService;
    @Autowired 
    private ReviewService reviewService;

    @GetMapping("/review/{id}")
    public Review getReview(@PathVariable Long id){
            return reviewService.getById(id);
    }

    // @GetMapping("/reviews/{userId}")
    // public List<Review> getReviews(@PathVariable Long userId){
    //     return reviewService.findReviewsByUser(userId);
    // }
    @GetMapping("/myreview")
    public String getReviews(Model model,Principal principal) {
        String  username=principal.getName();
        User user=userService.findByUsername(username);
        List<Review> reviews=reviewService.findReviewsByUser(user);
        model.addAttribute("reviews", reviews );
        return "Myreview";
    }
    @GetMapping("/review/add/{id}")
    public String addreview(@PathVariable Long id,Model model, Principal principal) {
        String  username=principal.getName();
        User user=userService.findByUsername(username);
        Review review= new Review();
        review.setUser(user);
        review.setMovieId(id);
        model.addAttribute("review",review);
        return "writereview";
    }
    
    @PostMapping("/writereview")
    public String addReview(@ModelAttribute Review review){
         reviewService.save(review);
         return "logindex";
    }
        @PostMapping("/review/edit/{id}")
        public Review updatePost(@RequestBody Review review,@PathVariable Long id){

            Review rev = reviewService.getById(id);
            rev.setDescription(review.getDescription());
            rev.setBody(review.getBody());
            rev.setRating(review.getRating());
            return reviewService.save(rev);
    }

    @GetMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable Long id){

            Review review= reviewService.getById(id);
            reviewService.delete(review);
            return "Deletion Successful";
    }
}
