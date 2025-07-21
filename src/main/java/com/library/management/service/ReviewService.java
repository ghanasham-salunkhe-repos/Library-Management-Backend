package com.library.management.service;

import com.library.management.dto.outputs.ReviewInformationDTO;

import java.util.List;

public interface ReviewService {

    List<ReviewInformationDTO> getAllReviews();
}
