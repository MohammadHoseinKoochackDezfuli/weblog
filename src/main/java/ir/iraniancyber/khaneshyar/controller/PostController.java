package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.service.post.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/count")
    public long count() {
        return postService.count();
    }

    @GetMapping("/findBySlug")
    public Optional<Post> findBySlug(@RequestParam String slug) {
        return postService.findBySlug(slug);
    }

    @GetMapping("/findByCategoryId")
    public List<Post> findTop10ByCategoryId(@RequestParam String slug) {
        return postService.findTop10ByCategoryId(slug);
    }

    @GetMapping("/findTop4ByOrderByCreatedAtDesc")
    public List<Post> findTop4ByOrderByCreatedAtDesc() {
        return postService.findTop4ByOrderByCreatedAtDesc();
    }

    @GetMapping("/findTop10ByOrderByCreatedAtDesc")
    public List<Post> findTop10ByOrderByCreatedAtDesc() {
        return postService.findTop10ByOrderByCreatedAtDesc();
    }

    @GetMapping("/findTop4ByOrderByViewsDesc")
    public List<Post> findTop4ByOrderByViewsDesc() {
        return postService.findTop4ByOrderByViewsDesc();
    }

    @GetMapping("/findTop10ByOrderByViewsDesc")
    public List<Post> findTop10ByOrderByViewsDesc() {
        return postService.findTop10ByOrderByViewsDesc();
    }

    @GetMapping("/findByTitleContaining")
    public List<Post> findByTitleContaining(@RequestParam String search) {
        return postService.findByTitleContaining(search);
    }
}
