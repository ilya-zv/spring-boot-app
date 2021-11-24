package ru.zvor.spring.service.repo;

import ru.zvor.spring.models.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> findAllGenres();
    Genre getGenreByName(String nameGenre);
    void saveNewGenre(String genreName);
    void updateGenreNameById(String genreName, Long genreId);
    void deleteGenreById(Long id);
}
