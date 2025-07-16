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

@Tag(name = "Book Issue Management", description = "Book issuing endpoints")
@RestController
@RequestMapping("/api/issues")
@Slf4j
public class IssueController {

    private final IssuedBookService issuedBookService;

    public IssueController(IssuedBookService issuedBookService) {
        this.issuedBookService = issuedBookService;
    }

    @GetMapping({"/all", ""})
    public ResponseEntity<List<IssuedBookInformationDTO>> getAllIssuedBooksInformation() {
        log.info("[GET][/api/issues/all] find all issued books details");
        return ResponseEntity.ok(issuedBookService.getAllIssuedBooksInformation());
    }

    @GetMapping(path = {"/active"})
    ResponseEntity<List<IssuedBookInformationDTO>> getAllActiveIssuedBooksInformation() {
        log.info("[GET][/api/issues/active] find all active issued books details");
        return ResponseEntity.ok(issuedBookService.getNotReturnedIssuedBooksInformation());
    }

    @GetMapping("/{issuedBookId}")
    ResponseEntity<IssuedBookInformationDTO> getIssuedBookInformation(@PathVariable Long issuedBookId) {
        log.info("[GET][/api/issues/{}] searching issued book details for {}", issuedBookId, issuedBookId);
        return ResponseEntity.ok(issuedBookService.getIssuedBooksInformationById(issuedBookId));
    }


    @GetMapping("/overdue/{inputDate}")
    ResponseEntity<List<IssuedBookInformationDTO>> getAllOverdueIssuedBooksInformation(@PathVariable String inputDate) {
        log.info("[GET][/api/issues/overdue] find all overdue issued books details]");
        LocalDate dueDate = LocalDate.parse(inputDate);
        return ResponseEntity.ok(issuedBookService.getAllOverdueIssuedBooksInformation(dueDate));
    }

    @GetMapping("/overdue")
    ResponseEntity<List<IssuedBookInformationDTO>> getAllOverdueIssuedBooksOnCurrentDateInformation() {
        log.info("[GET][/api/issues/overdue] find all overdue issued books details on current date]");
        LocalDate dueDate = LocalDate.now();
        return ResponseEntity.ok(issuedBookService.getAllOverdueIssuedBooksInformation(dueDate));
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<List<IssuedBookInformationDTO>> getAllIssuedBooksForCustomer(@PathVariable Long customerId) {
        log.info("[GET][/api/issues/customer/customer/{}] finding all book issue information for {}", customerId, customerId);
        return ResponseEntity.ok(issuedBookService.getAllIssuedBooksForCustomer(customerId));
    }

}
