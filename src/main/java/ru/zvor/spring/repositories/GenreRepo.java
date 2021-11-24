package ru.zvor.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zvor.spring.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreRepo extends JpaRepository<Genre, Long> {
    List<Genre> findAll();
    Genre findByGenreOfBook(String nameGenre);
    Optional<Genre> findById(Long id);
    Genre save(Genre genre);
    void deleteById(int id);

    @Modifying
    @Query("update Genre g set g.genreOfBook = :genreName where g.id = :genreId")
    void setGenreNameById(@Param("genreName") String genreName, @Param("genreId") Long genreId);
}
