package ru.zvor.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zvor.spring.models.Book;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
    List<Book> findAll();
    Book save(Book book);
    void deleteById(Long id);

    @Modifying
    @Query("update Book b set b.name = :nameBook where b.id = :bookId")
    void setBookNameById(@Param("nameBook") String nameBook, @Param("bookId") Long bookId);

}
