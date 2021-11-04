package ru.zvor.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.zvor.spring.domain.Author;
import ru.zvor.spring.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class LibraryDaoImpl implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insertBookAndAuthor(Book book, Author author) {
        jdbc.update("insert into author (author_id, name) values (:author_id, :name)",
                Map.of("author_id", author.getId(), "name", author.getName()));
        jdbc.update("insert into book (book_id, name, author_id) values (:book_id, :name, :author_id)",
                Map.of("book_id", book.getId(), "name", book.getName(), "author_id", book.getAuthor()));
    }
    public void insertAuthor(Author author) {
        jdbc.update("insert into author (author_id, name) values (:author_id, :name)",
                Map.of("author_id", author.getId(), "name", author.getName()));
    }

    public Book getBookById (long book_id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("book_id", book_id);
        return jdbc.queryForObject("select * from book where book_id = :book_id",
                Map.of("book_id", book_id), new BookMapper());
    }
    public Author getAuthorById (long author_id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("author_id", author_id);
        return jdbc.queryForObject("select * from author where author_id = :author_id",
                Map.of("author_id", author_id), new AuthorMapper());
    }
    public List<Book> getAllBookByAuthor (long author_id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("author_id", author_id);
        return jdbc.query("select * from book where author_id = :author_id",
                Map.of("author_id", author_id), new BookMapper());
    }
    public List<Author> getAllAuthorByBookName (String name) {
        final Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return jdbc.query("select * from author join book using (AUTHOR_ID) where BOOK.NAME = :name",
                Map.of("name", name), new AuthorMapper());
    }
    public List<Author> getAllAuthorByBookId (long book_id) {
        final Map<String, Object> params = new HashMap<>();
        params.put("book_id", book_id);
        return jdbc.query("select * from author join book using (AUTHOR_ID) where BOOK.NAME  = select NAME from BOOK where BOOK_ID = :book_id",
                Map.of("book_id", book_id), new AuthorMapper());
    }


    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("book_id");
            String name = resultSet.getString("name");
            Long author = resultSet.getLong("author_id");
            return new Book(id, name, author);
        }
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("author_id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
