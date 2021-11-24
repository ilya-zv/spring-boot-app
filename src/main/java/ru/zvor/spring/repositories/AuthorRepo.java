package ru.zvor.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zvor.spring.models.Author;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Author findByNameAuthor(String name);


    Author save(Author author);
    void deleteByNameAuthor(String nameAuthor);

    @Modifying
    @Query("update Author a set a.nameAuthor = :nameAuthor where a.id = :authorId")
    void setAuthorNameById(@Param("nameAuthor") String nameAuthor, @Param("authorId") Long authorId);
}
