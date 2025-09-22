package ir.iraniancyber.khaneshyar.service.Comment;

import ir.iraniancyber.khaneshyar.model.Comment;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import ir.iraniancyber.khaneshyar.repository.CommentRepository;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    @Override
    public void save(Comment comment)
    {
        commentRepository.save(comment);
    }
}
