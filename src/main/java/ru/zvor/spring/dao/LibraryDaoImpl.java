package ru.zvor.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.zvor.spring.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class LibraryDaoImpl implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoImpl(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into book (id, name, FK_AUTHOR_ID) values (:id, :name, :FK_AUTHOR_ID)",
                Map.of("id", book.getId(), "name", book.getName(), "FK_AUTHOR_ID", book.getAuthor()));
        jdbc.update("insert into author (id, name) values (:id, :name)",
                Map.of("id", book.getId(), "name", book.getName()));
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            Long author = resultSet.getLong("author");
            return new Book(id, name, author);
        }
    }
}
