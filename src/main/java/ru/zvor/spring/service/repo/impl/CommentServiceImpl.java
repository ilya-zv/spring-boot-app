package ru.zvor.spring.service.repo.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zvor.spring.models.Comment;
import ru.zvor.spring.repositories.CommentRepo;
import ru.zvor.spring.service.repo.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAllComment() {
        return commentRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepo.findById(commentId);
    }

    @Override
    @Transactional
    public void saveNewComment(String commentName) {
        if (!commentRepo.findByCommentName(commentName).isPresent()) {
            Comment comment = new Comment();
            comment.setCommentName(commentName);
            commentRepo.save(comment);
            System.out.println("Комментарий добавлен.");
        } else {
            System.out.println("Комментарий уже существует.");
        }
    }

    @Override
    @Transactional
    public void updateCommentNameById(String commentName, Long commentId) {
        if (commentRepo.findById(commentId).isPresent()) {
            commentRepo.setCommentTextById(commentName, commentId);
            System.out.println("Комментарий успешно обновлен.");
        } else {
            System.out.printf("Комментарий с ID:%s отсутствует в библиотеке.\n", commentId);
        }
    }

    @Override
    @Transactional
    public void deleteCommentById(Long commentId) {
        if (commentRepo.findById(commentId).isPresent()) {
            commentRepo.deleteById(commentId);
            System.out.println("Комментарий успешно удален.");
        } else {
            System.out.printf("Комментарий с ID:%s не найден.\n", commentId);
        }
    }
}
