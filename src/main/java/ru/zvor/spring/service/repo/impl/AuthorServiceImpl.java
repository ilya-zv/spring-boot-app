package ru.zvor.spring.service.repo.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zvor.spring.models.Author;
import ru.zvor.spring.repositories.AuthorRepo;
import ru.zvor.spring.service.repo.AuthorService;

import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {


    AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }


    @Override
    @Transactional
    public void saveNewAuthor(String nameAuthor) {
        if (authorRepo.findByNameAuthor(nameAuthor) == null) {
            Author author = new Author();
            author.setNameAuthor(nameAuthor);
            authorRepo.save(author);
            System.out.printf("Автор '%s' добавлен в библиотеку!\n", nameAuthor);
        } else {
            System.out.printf("Автор '%s' уже существует в библиотеке!\n", nameAuthor);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public String findAllAuthor() {
        return authorRepo.findAll().toString();
    }

    @Override
    public void updateNameAuthorById(Long id, String nameAuthor) {
        var author = authorRepo.findById(id);
        if (author.isPresent()) {
            author.get().setNameAuthor(nameAuthor);
            authorRepo.save(author.get());
            System.out.printf("Запись '%s' обновлена.\n", nameAuthor);
        } else {
            System.out.printf("Запись '%s' с данным ID не найдена.\n", nameAuthor);
        }
    }

    @Override
    @Transactional
    public void removeAuthorByName(String name) {
        authorRepo.deleteByNameAuthor(name);
    }


}
