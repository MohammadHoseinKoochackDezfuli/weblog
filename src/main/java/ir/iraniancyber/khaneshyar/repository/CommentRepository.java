package ir.iraniancyber.khaneshyar.repository;

import ir.iraniancyber.khaneshyar.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment save(Comment comment);
}
