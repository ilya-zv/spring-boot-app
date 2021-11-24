package ru.zvor.spring.service.repo.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zvor.spring.models.Genre;
import ru.zvor.spring.repositories.GenreRepo;
import ru.zvor.spring.service.repo.GenreService;

import java.util.List;
import java.util.Locale;

@Service
public class GenreServiceImpl implements GenreService {

    GenreRepo genreRepo;

    public GenreServiceImpl(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Genre> findAllGenres() {
        return genreRepo.findAll();
    }

    @Override
    @Transactional
    public Genre getGenreByName(String nameGenre) {
        return genreRepo.findByGenreOfBook(nameGenre);
    }

    @Override
    @Transactional
    public void saveNewGenre(String genreName) {
        if (genreRepo.findByGenreOfBook(genreName.toLowerCase(Locale.ROOT)) == null) {
            Genre genre = new Genre();
            genre.setGenreOfBook(genreName.toLowerCase(Locale.ROOT));
            genreRepo.save(genre);
            System.out.printf("Жанр '%s' успешно добавлен в библиотеку.\n", genreName);
        } else {
            System.out.printf("Жанр '%s' уже существует в библиотеке.\n", genreName);
        }
    }

    @Override
    @Transactional
    public void updateGenreNameById(String genreName, Long genreId) {
        if (genreRepo.findById(genreId).isPresent()) {
            genreRepo.setGenreNameById(genreName, genreId);
            System.out.printf("Жанр '%s' успешно обновлен.\n", genreName);
        } else {
            System.out.println("Жанра с таким ID не найдено.");
        }
    }

    @Override
    @Transactional
    public void deleteGenreById(Long id) {
        if (genreRepo.findById(id).isPresent()) {
            genreRepo.deleteById(id);
            System.out.println("Жанр успешно удален.");
        } else {
            System.out.println("Жанра с таким ID не найдено.");
        }
    }
}
