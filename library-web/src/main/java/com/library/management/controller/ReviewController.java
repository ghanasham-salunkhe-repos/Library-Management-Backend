package com.library.management.controller;

import com.library.management.dto.outputs.ReviewInformationDTO;
import com.library.management.service.ReviewService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Book Reviews", description = "Book reviews endpoints")
@RestController
@RequestMapping("/api/reviews")
@Slf4j
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("")
    ResponseEntity<List<ReviewInformationDTO>> getAllBookReviews() {
        log.info("[GET][/api/reviews/] get all reviews");
        return ResponseEntity.ok(reviewService.getAllReviews());
    }
}
