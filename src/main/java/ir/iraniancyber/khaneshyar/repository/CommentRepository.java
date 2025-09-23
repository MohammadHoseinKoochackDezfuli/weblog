package ir.iraniancyber.khaneshyar.repository;

import ir.iraniancyber.khaneshyar.dto.CommentAdmin;
import ir.iraniancyber.khaneshyar.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment save(Comment comment);
    List<Comment> findAllByPostIdAndApproved(int id,Boolean approved);
    List<Comment> findAll();
    Optional<Comment> findAllById(int id);
}
