package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findTop4ByOrderByCreatedAtDesc();
    long count();
    List<Post> findTop4ByOrderByViewsDesc();
    Optional<Post> findBySlug(String slug);
}
