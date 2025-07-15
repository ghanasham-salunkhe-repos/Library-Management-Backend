package com.library.management.repositories;

import com.library.management.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {

    List<IssuedBook>  findByBookId(Long issuedBookId);
    List<IssuedBook> findAllByIsReturned(Boolean isReturned);
    List<IssuedBook> findAllByFineAmountGreaterThan(Double fineAmountIsGreaterThan);
    List<IssuedBook> findAllByDueDateBeforeAndIsReturned(LocalDate dueDateAfter, Boolean isReturned);
    List<IssuedBook> findAllByCustomer_Id(Long customerId);
}
