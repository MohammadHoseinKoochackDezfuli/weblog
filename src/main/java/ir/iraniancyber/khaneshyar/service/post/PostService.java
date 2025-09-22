package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    long count();

    List<Post> findTop4ByOrderByCreatedAtDesc();

    List<Post> findTop10ByOrderByCreatedAtDesc();

    List<Post> findTop4ByOrderByViewsDesc();

    List<Post> findTop10ByOrderByViewsDesc();

    List<Post> findTop10ByCategoryId(String slug);

    Optional<Post> findBySlug(String slug);

    List<Post> findByTitleContaining(String search);
}
