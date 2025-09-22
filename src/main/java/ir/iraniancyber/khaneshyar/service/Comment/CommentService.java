package ir.iraniancyber.khaneshyar.service.Comment;

import ir.iraniancyber.khaneshyar.dto.CommentDto;
import ir.iraniancyber.khaneshyar.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<CommentDto> findAllByPostId(int id);
}
