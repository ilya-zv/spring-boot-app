package ru.zvor.spring.service.repo.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.zvor.spring.repositories.AuthorRepo;
import ru.zvor.spring.repositories.BookRepo;
import ru.zvor.spring.repositories.GenreRepo;
import ru.zvor.spring.service.repo.BookService;

@Service
public class BookServiceImpl implements BookService {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private GenreRepo genreRepo;

    public BookServiceImpl(AuthorRepo authorRepo, BookRepo bookRepo, GenreRepo genreRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.genreRepo = genreRepo;
    }



/*    @Override
    @Transactional
    public boolean saveNewBook(String nameBook, String nameAuthor, String nameGenre) {

        Book book = new Book();
        book.setName(nameBook);

        List<Author> authors = authorRepo.findAllByName_author(nameAuthor);

        if(authors.size() > 0) {
            book.setAuthor(authors);
        } else {
            System.out.println("Автор отсутствует в библиотеке, сначала добавьте нового автора");
            return false;
        }

        List<Genre> genres = genreRepo.findAllByGenre_of_book(nameGenre);

        if (genres.size() > 0) {
            book.setGenre(genres);
        } else {
            System.out.println("Жанр отсутствует в библиотеке, сначала добавьте новый жанр");
            return false;
        }
        return true;
    }*/
}
