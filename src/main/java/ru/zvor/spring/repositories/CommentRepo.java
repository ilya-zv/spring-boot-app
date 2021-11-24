package ru.zvor.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.zvor.spring.models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    Optional<Comment> findById(Long id);
    Optional<Comment> findByCommentName(String commentName);
    Comment save(Comment comment);
    List<Comment> findAll();
    void deleteById(Long id);

    @Modifying
    @Query("update Comment c set c.commentName = :commentName where c.id = :commentId")
    void setCommentTextById(@Param("commentName") String commentName, @Param("commentId") Long commentId);

}
