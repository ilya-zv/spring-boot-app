package ru.zvor.spring.service.repo;

import ru.zvor.spring.models.Comment;


import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAllComment();
    Optional<Comment> getCommentById(Long commentId);
    void saveNewComment(String commentName);
    void updateCommentNameById(String commentName, Long commentId);
    void deleteCommentById(Long commentId);
}
