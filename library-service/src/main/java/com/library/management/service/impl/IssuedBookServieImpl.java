package com.library.management.service.impl;

import com.library.management.dto.outputs.IssuedBookInformationDTO;
import com.library.management.exceptions.IssueBookIdNotFound;
import com.library.management.mapper.LibraryManagementMapper;
import com.library.management.repositories.IssuedBookRepository;
import com.library.management.service.IssuedBookService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IssuedBookServieImpl implements IssuedBookService {

    private final IssuedBookRepository issuedBookRepository;

    public IssuedBookServieImpl(IssuedBookRepository issuedBookRepository) {
        this.issuedBookRepository = issuedBookRepository;
    }

    // all issue details
    @Override
    public List<IssuedBookInformationDTO> getAllIssuedBooksInformation() {
        return issuedBookRepository.findAll().stream()
                .map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO)
                .toList();
    }

    @Override
    public IssuedBookInformationDTO getIssuedBooksInformationById(Long issuedBookId) {
        return LibraryManagementMapper.issuedBookToissuedBookInformationDTO(
                issuedBookRepository.findById(issuedBookId).orElseThrow(
                        () -> new IssueBookIdNotFound(issuedBookId)
                )
        );
    }

    @Override
    public List<IssuedBookInformationDTO> getNotReturnedIssuedBooksInformation() {

        return issuedBookRepository.findAllByIsReturned(false)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public List<IssuedBookInformationDTO> getReturnedIssuedBooksInformation() {
        return issuedBookRepository.findAllByIsReturned(true)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public List<IssuedBookInformationDTO> getAllFinedIssuedBooksInformation() {
        return issuedBookRepository.findAllByFineAmountGreaterThan(0.0)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public List<IssuedBookInformationDTO> getAllOverdueIssuedBooksInformation(LocalDate dueDateAfter) {
        return issuedBookRepository.findAllByDueDateBeforeAndIsReturned(dueDateAfter, false)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public List<IssuedBookInformationDTO> getAllIssuedBooksForCustomer(Long customerId) {
        return issuedBookRepository.findAllByCustomer_Id(customerId)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public Double getFineOnFromPerticularUser(Long customerId) {
        return issuedBookRepository.getTotalFineByUserId(customerId);
    }

    @Override
    public Double getFineOnToPerticularDate(LocalDate fineDate) {
        return issuedBookRepository.getTotalFinedCollectedOnDate(fineDate);
    }

    @Override
    public List<IssuedBookInformationDTO> getIssuedBooksInformationByReturnDate(LocalDate returnDate) {
        return issuedBookRepository.findAllByReturnDate(returnDate)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

    @Override
    public List<IssuedBookInformationDTO> getReturnedIssuedBooksInformationByCustomerId(Long customerId) {
        return issuedBookRepository.findAllByIsReturnedAndCustomer_Id(true, customerId)
                .stream().map(LibraryManagementMapper::issuedBookToissuedBookInformationDTO).toList();
    }

}
