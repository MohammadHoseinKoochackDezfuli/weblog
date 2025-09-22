package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.CommentDto;
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
import java.util.List;

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
    @GetMapping("/findAllBySlug")
    public List<CommentDto> findAll(@RequestParam String slug)
    {
        return commentService.findAllByPostId(postRepository.findBySlug(slug).get().getId());
    }

    @GetMapping("/save")
    public void save(@RequestParam String postSlug ,@RequestParam String text, HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(username).get();
        Post post = postRepository.findBySlug(postSlug).get();

        Comment comment = new Comment(0, text, user.getUsername(), user.getEmail(), null, LocalDateTime.now(), post);
        commentService.save(comment);
    }

}
