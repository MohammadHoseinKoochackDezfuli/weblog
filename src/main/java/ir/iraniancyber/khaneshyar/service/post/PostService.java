package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.dto.PostAdmin;
import ir.iraniancyber.khaneshyar.model.Post;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface PostService {
    long count();

    List<Post> findTop4ByOrderByCreatedAtDesc();

    List<Post> findTop10ByOrderByCreatedAtDesc();

    List<Post> findTop4ByOrderByViewsDesc();

    List<Post> findTop10ByOrderByViewsDesc();

    List<Post> findTop10ByCategoryId(String slug);

    Post findBySlug(String slug);

    List<Post> findByTitleContaining(String search);

    List<PostAdmin> findAll();

    void delete(int id);

    void add(HttpServletRequest request);

    Optional<Post> findById(int id);

    void update(Post post,int categoryId);

}
