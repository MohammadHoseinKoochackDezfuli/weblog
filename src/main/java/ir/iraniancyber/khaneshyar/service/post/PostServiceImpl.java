package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import ir.iraniancyber.khaneshyar.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> findTop4ByOrderByCreatedAtDesc() {
        return postRepository.findTop4ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Post> findTop10ByOrderByCreatedAtDesc() {
        return postRepository.findTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public long count() {
        return postRepository.count();
    }

    @Override
    public List<Post> findTop4ByOrderByViewsDesc() {
        return postRepository.findTop4ByOrderByViewsDesc();
    }

    @Override
    public List<Post> findTop10ByOrderByViewsDesc() {
        return postRepository.findTop10ByOrderByViewsDesc();
    }

    @Override
    public Optional<Post> findBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

    @Override
    public List<Post> findTop10ByCategoryId(String slug) {
        int id = categoryRepository.findAllBySlug(slug).get(0).getId();
        return postRepository.findTop10ByCategoryId(id);
    }
    @Override
    public List<Post> findByTitleContaining(String search)
    {
        return postRepository.findByTitleContaining(search);
    }
}
