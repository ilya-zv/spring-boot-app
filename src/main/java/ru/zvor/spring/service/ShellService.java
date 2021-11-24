/*
package ru.zvor.spring.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.zvor.spring.repositories.LibraryDao;
import ru.zvor.spring.models.Author;
import ru.zvor.spring.models.Book;

@ShellComponent
public class ShellService {

    private LibraryDao dao;
    private IOService ioService;

    public ShellService(LibraryDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @ShellMethod(value = "Добавляет автора в базу данных", key = "ia")
    public void insertAuthor(int id, String name) {
        dao.insertAuthor(new Author(id, name));
        System.out.println("Автор успешно добавлен в БД.");
    }

    @ShellMethod(value = "Добавляет автора и книгу в базу данных", key = "iab")
    public void insertBookAndAuthor(int book_id, String book_name, int author_id, String author_name) {
        dao.insertBookAndAuthor(new Book(book_id, book_name, author_id), new Author(author_id, author_name));
        System.out.println("Автор и книга успешно добавлены в БД.");
    }

    @ShellMethod(value = "Выводит книгу по ID", key = "gbbi")
    public void getBookById(long id) {
        ioService.whrite(dao.getBookById(id).toString());
    }

    @ShellMethod(value = "Выводит все книги в БД", key = "gab")
    public void getAllBook() {
        dao.getAllBook().stream().map((i) -> "Книга: " + i.getId() + ". Название: " + i.getName() + ". Автор № " + i.getAuthor()).forEach(System.out::println);
    }

    @ShellMethod(value = "Выводит всех авторов в БД", key = "gaa")
    public void getAllAuthor() {
        dao.getAllAuthor().stream().map((i) -> "Автор: " + i.getId() + ". Ф.И.О: " + i.getName()).forEach(System.out::println);
    }

    @ShellMethod(value = "Удаляет книгу из БД", key = "db")
    public void deleteBook(int id) {
        dao.deleteByBookId(id);
        ioService.whrite("Книга удалена!");
    }

    @ShellMethod(value = "Удаляет автора из БД", key = "da")
    public void deleteAuthor(long id) {
        dao.deleteByAuthorId(id);
    }

}
*/
