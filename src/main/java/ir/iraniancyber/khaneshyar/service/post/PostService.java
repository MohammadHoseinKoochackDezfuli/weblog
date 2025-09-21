package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.model.Post;

import java.util.List;

public interface PostService {
    List<Post> findTop4ByOrderByCreatedAtDesc();
    long count();
    List<Post> findTop4ByOrderByViewsDesc();
}
