package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.service.post.PostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/findTop4ByOrderByCreatedAtDesc")
    public List<Post> findTop4ByOrderByCreatedAtDesc() {
        return postService.findTop4ByOrderByCreatedAtDesc();
    }
    @GetMapping("/count")
    public long count()
    {
        return postService.count();
    }
}
