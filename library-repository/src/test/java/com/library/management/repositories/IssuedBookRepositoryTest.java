//package com.library.management.repositories;
//
//import com.library.management.model.IssuedBook;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@ContextConfiguration(classes = com.library.management.LibraryManagementApplication.class)
//@DataJpaTest
//class IssuedBookRepositoryTest {
//
//    @Autowired
//    private IssuedBookRepository issuedBookRepository;
//
//    @Test
//    @DisplayName("Should find issued books by isReturned status")
//    void testFindAllByIsReturned() {
//        IssuedBook issuedBook = new IssuedBook();
//        issuedBook.setIsReturned(false);
//        issuedBookRepository.save(issuedBook);
//
//        List<IssuedBook> result = issuedBookRepository.findAllByIsReturned(false);
//        assertThat(result).isNotEmpty();
//        assertThat(result.get(0).getIsReturned()).isFalse();
//    }
//
//    @Test
//    @DisplayName("Should find issued books by fine amount greater than value")
//    void testFindAllByFineAmountGreaterThan() {
//        IssuedBook issuedBook = new IssuedBook();
//        issuedBook.setFineAmount(50.0);
//        issuedBookRepository.save(issuedBook);
//
//        List<IssuedBook> result = issuedBookRepository.findAllByFineAmountGreaterThan(10.0);
//        assertThat(result).isNotEmpty();
//        assertThat(result.get(0).getFineAmount()).isGreaterThan(10.0);
//    }
//
//    @Test
//    @DisplayName("Should find issued books by due date before and isReturned")
//    void testFindAllByDueDateBeforeAndIsReturned() {
//        IssuedBook issuedBook = new IssuedBook();
//        issuedBook.setDueDate(LocalDate.now().minusDays(1));
//        issuedBook.setIsReturned(false);
//        issuedBookRepository.save(issuedBook);
//
//        List<IssuedBook> result = issuedBookRepository.findAllByDueDateBeforeAndIsReturned(LocalDate.now(), false);
//        assertThat(result).isNotEmpty();
//        assertThat(result.get(0).getDueDate()).isBefore(LocalDate.now());
//        assertThat(result.get(0).getIsReturned()).isFalse();
//    }
//}
//
