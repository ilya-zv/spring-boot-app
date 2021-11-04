package ru.zvor.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.zvor.spring.dao.LibraryDao;
import ru.zvor.spring.domain.Author;
import ru.zvor.spring.domain.Book;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);
        LibraryDao dao = context.getBean(LibraryDao.class);
//        dao.insertBookAndAuthor(new Book(11, "Book of John", 8), new Author(8, "John Smith"));
//        System.out.println(dao.getAuthorById(dao.getBookById(1).getAuthor()));
//        System.out.println(dao.getAllBookByAuthor(1));
//        System.out.println(dao.getAllAuthorByBookName(dao.getBookById(8).getName()));
//        System.out.println(dao.getAllAuthorByBookId(8));
//        dao.insertAuthor(new Author(14, "Fedor Dostoevskiy"));
//        Console.main(args);
    }
}
