package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findTop4ByOrderByCreatedAtDesc() {
        return postRepository.findTop4ByOrderByCreatedAtDesc();
    }
    @Override
    public long count()
    {
        return postRepository.count();
    }
}
