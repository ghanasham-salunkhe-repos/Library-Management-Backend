package com.library.management.repositories;

import com.library.management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// this repository should extend the jparepository interface
// this BookTableRepository will be autowired by spring boot
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAvailableCopiesEquals(Integer count);

    List<Book> findALlByAvailableCopiesGreaterThan(Integer count);
}
