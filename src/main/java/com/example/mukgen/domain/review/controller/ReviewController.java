package com.example.mukgen.domain.review.controller;

import com.example.mukgen.domain.review.controller.dto.request.ReviewCreateRequest;
import com.example.mukgen.domain.review.controller.dto.response.ReviewRankResponse;
import com.example.mukgen.domain.review.controller.dto.response.ReviewResponseList;
import com.example.mukgen.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/{mealId}")
    public void reviewAdd(
            @PathVariable int mealId,
            @RequestBody ReviewCreateRequest request
    ){
        reviewService.addReview(request,mealId);
    }

    @GetMapping("/{mealId}")
    public ReviewResponseList reviewDetails(
            @PathVariable int mealId
    ){
        return reviewService.findReview(mealId);
    }

    @GetMapping("/rank")
    public ReviewRankResponse reviewRankList(){
        return reviewService.findRankReview();
    }

    @GetMapping
    public ReviewResponseList reviewList(){
        return reviewService.findAllReview();
    }

}
