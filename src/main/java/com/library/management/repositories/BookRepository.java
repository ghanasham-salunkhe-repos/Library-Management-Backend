package com.library.management.repositories;

import com.library.management.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this repository should extend the jparepository interface
// this BookTableRepository will be autowired by spring boot
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
