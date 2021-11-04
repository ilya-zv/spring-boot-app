package ru.zvor.spring.service;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.zvor.spring.dao.LibraryDao;

@ShellComponent
public class ShellServiceImpl implements ShellService {

    private LibraryDao dao;
    private IOService ioService;

    public ShellServiceImpl(LibraryDao dao, IOService ioService) {
        this.dao = dao;
        this.ioService = ioService;
    }

    @ShellMethod(value = "Выводит книгу по ID", key = "gbbi")
    public void getBookById(long id) {
        ioService.whrite(dao.getBookById(id).toString());
    }

}
