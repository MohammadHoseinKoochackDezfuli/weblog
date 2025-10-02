package ir.iraniancyber.khaneshyar.service.Comment;

import ir.iraniancyber.khaneshyar.dto.comment.CommentAdmin;
import ir.iraniancyber.khaneshyar.dto.comment.CommentDto;
import ir.iraniancyber.khaneshyar.model.Comment;
import ir.iraniancyber.khaneshyar.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Override
    public List<CommentAdmin> findAll()
    {
        List<Comment> comments=commentRepository.findAll();
        List<CommentAdmin> commentAdmins=new ArrayList<>();
        for(int i=0;i<comments.size();i++)
        {
            Comment comment=comments.get(i);
            commentAdmins.add(new CommentAdmin(comment.getId(),comment.getContent(),comment.getAuthorName(),comment.getAuthorEmail(),comment.getApproved(),comment.getCreatedAt(), comment.getPost().getSlug()));
        }
        return commentAdmins;
    }
    @Override
    public Optional<Comment> findAllById(int id)
    {
        return commentRepository.findById(id);
    }
}
