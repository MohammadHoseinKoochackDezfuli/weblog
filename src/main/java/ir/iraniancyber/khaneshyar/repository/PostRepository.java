package ir.iraniancyber.khaneshyar.repository;

import ir.iraniancyber.khaneshyar.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findTop4ByOrderByCreatedAtDesc();
    long count();
    List<Post> findTop4ByOrderByViewsDesc();
}
