package ru.zvor.spring.service.repo;

public interface AuthorService {
    void saveNewAuthor(String nameAuthor);
    String findAllAuthor();
    void updateNameAuthorById(Long id, String nameAuthor);
    void removeAuthorByName(String name);
}
