package ru.zvor.spring;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.zvor.spring.dao.LibraryDao;
import ru.zvor.spring.domain.Book;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Main.class);
        LibraryDao dao = context.getBean(LibraryDao.class);
//        dao.insert(new Book(7, "sdfs", 1));
        Console.main(args);
    }
}
