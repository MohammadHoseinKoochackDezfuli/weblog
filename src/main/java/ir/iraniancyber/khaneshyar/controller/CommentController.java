package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.CommentRequest;
import ir.iraniancyber.khaneshyar.model.Comment;
import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.model.User;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import ir.iraniancyber.khaneshyar.repository.UserRepository;
import ir.iraniancyber.khaneshyar.service.Comment.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/comments")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommentController {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentService commentService;

    public CommentController(CommentService commentService, UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentService = commentService;
    }


    @PostMapping
    public void save(@RequestBody CommentRequest commentRequest, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username).get();
        Post post = postRepository.findById(commentRequest.getPostId()).get();

        Comment comment = new Comment(0, commentRequest.getContent(), user.getUsername(), user.getEmail(), null, LocalDateTime.now(), post);
        commentService.save(comment);
    }

}
