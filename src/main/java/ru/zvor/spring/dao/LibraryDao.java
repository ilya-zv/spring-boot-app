package ru.zvor.spring.dao;

import ru.zvor.spring.domain.Author;
import ru.zvor.spring.domain.Book;

import java.util.List;

public interface LibraryDao {
    public void insertAuthor(Author author);
    public void insertBookAndAuthor(Book book, Author author);
    public Book getBookById(long id);
    public List<Book> getAllBook();
    public List<Author> getAllAuthor();
    public Author getAuthorById(long author_id);
    public List<Book> getAllBookByAuthor(long author_id);
    public List<Author> getAllAuthorByBookName(String book_name);
    public List<Author> getAllAuthorByBookId(long id);
    public void deleteByBookId (long book_id);
    public void deleteByAuthorId (long author_id);
}
