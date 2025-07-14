package com.library.management.repositories;

import com.library.management.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {

    List<IssuedBook>  findByBookId(Long issuedBookId);
    List<IssuedBook> findAllByIsReturned(Boolean isReturned);
}
