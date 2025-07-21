package com.library.management.service.impl;

import com.library.management.dto.outputs.ReviewInformationDTO;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.repositories.ReviewRepository;
import com.library.management.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<ReviewInformationDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream().map(LibraryManagementMapper::reviewToReviewInformationDTO).toList();
    }
}
