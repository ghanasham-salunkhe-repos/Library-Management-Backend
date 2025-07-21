package com.library.management.controller;

import com.library.management.dto.outputs.IssuedBookInformationDTO;
import com.library.management.service.IssuedBookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@Tag(name = "Returns Management", description = "Endpoints related to book returns ")
@RestController
@RequestMapping("/api/returns")
@Slf4j
public class ReturnController {

    public final IssuedBookService issuedBookService;

    public ReturnController(IssuedBookService issuedBookService) {
        this.issuedBookService = issuedBookService;
    }

    @GetMapping("/date/{localDate}")
    ResponseEntity<List<IssuedBookInformationDTO>> getFineOnFromPerticularDate(@PathVariable String localDate) {
        log.info("[GET][/api/returns/date/{}] find fine on from date {}]", localDate, localDate);
        return ResponseEntity.ok(issuedBookService.getIssuedBooksInformationByReturnDate(LocalDate.parse(localDate)));
    }

    @GetMapping(path = {"/incomplete"})
    ResponseEntity<List<IssuedBookInformationDTO>> getAllActiveIssuedBooksInformation() {
        log.info("[GET][/api/returns/active] find all active issued books details");
        return ResponseEntity.ok(issuedBookService.getNotReturnedIssuedBooksInformation());
    }

    @GetMapping("/complete")
    ResponseEntity<List<IssuedBookInformationDTO>> getAllCompletedIssuedBooksInformation() {
        log.info("[GET][/api/returns/completed] find all complete returns details");
        return ResponseEntity.ok(issuedBookService.getReturnedIssuedBooksInformation());
    }

    @GetMapping("/fine-entries/customerwise/{customerId}")
    ResponseEntity<Double> getFineOnFromPerticularDate(@PathVariable Long customerId) {
        log.info("[GET][/api/returns/fine-entries/customerwise/{}] find fine on from date {}]", customerId, customerId);
        return ResponseEntity.ok(issuedBookService.getFineOnFromPerticularUser(customerId));
    }

    @GetMapping("/history/{customerId}")
    ResponseEntity<List<IssuedBookInformationDTO>> getAllReturnedBookInformationCustomerWise(@PathVariable Long customerId) {
        log.info("[GET][/api/returns/history/{}] find fine on from date {}]", customerId, customerId);
        return ResponseEntity.ok(issuedBookService.getReturnedIssuedBooksInformationByCustomerId(customerId));
    }

    @GetMapping("/fine-entries")
    ResponseEntity<List<IssuedBookInformationDTO>> getIssuedBooksInformationById() {
        log.info("[GET][/api/returns/fine-entries] find all fined book issue details]");
        return ResponseEntity.ok(issuedBookService.getAllFinedIssuedBooksInformation());
    }
}
