package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.PostAdmin;
import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.model.Tag;
import ir.iraniancyber.khaneshyar.service.post.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    @GetMapping("findAll")
    public List<PostAdmin> findAll()
    {
        return postService.findAll();
    }
    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id)
    {
        postService.delete(id);
    }
    @GetMapping("/add")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void add(HttpServletRequest request)
    {
        postService.add(request);
    }
    @GetMapping("/update")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void update(@RequestParam int id,@RequestParam String title,@RequestParam String excerpt,@RequestParam String slug,@RequestParam int categoryId,@RequestParam String content)
    {
        Post post=postService.findById(id).get();
        post.setUpdateAt(LocalDateTime.now());
        post.setTitle(title);
        post.setSlug(slug);
        post.setContent(content);
        post.setExcerpt(excerpt);
        postService.update(post,categoryId);
    }
}
