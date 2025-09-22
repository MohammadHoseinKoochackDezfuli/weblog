package ir.iraniancyber.khaneshyar.service.Comment;

import ir.iraniancyber.khaneshyar.dto.CommentDto;
import ir.iraniancyber.khaneshyar.model.Comment;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import ir.iraniancyber.khaneshyar.repository.CommentRepository;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public List<CommentDto> findAllByPostId(int id)
    {
        List<Comment> comments=commentRepository.findAllByPostIdAndApproved(id,true);
        List<CommentDto> commentDtoList=new ArrayList<>();
        for(int i=0;i<comments.size();i++)
        {
            Comment comment=comments.get(i);
            commentDtoList.add(new CommentDto(comment.getContent(),comment.getAuthorName(),comment.getCreatedAt()));
        }
        return commentDtoList;
    }
}
