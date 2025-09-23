package ir.iraniancyber.khaneshyar.service.Comment;

import ir.iraniancyber.khaneshyar.dto.CommentAdmin;
import ir.iraniancyber.khaneshyar.dto.CommentDto;
import ir.iraniancyber.khaneshyar.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    void save(Comment comment);
    List<CommentDto> findAllByPostId(int id);
    List<CommentAdmin> findAll();
    Optional<Comment> findAllById(int id);
}
