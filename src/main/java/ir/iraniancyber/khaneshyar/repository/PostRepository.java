package ir.iraniancyber.khaneshyar.repository;

import ir.iraniancyber.khaneshyar.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findTop4ByOrderByCreatedAtDesc();

    List<Post> findTop10ByOrderByCreatedAtDesc();

    long count();

    List<Post> findTop4ByOrderByViewsDesc();

    List<Post> findTop10ByOrderByViewsDesc();

    Optional<Post> findBySlug(String slug);

    List<Post> findTop10ByCategoryId(int id);
}
