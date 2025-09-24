package ir.iraniancyber.khaneshyar.service.post;

import ir.iraniancyber.khaneshyar.dto.PostAdmin;
import ir.iraniancyber.khaneshyar.model.Post;
import ir.iraniancyber.khaneshyar.model.User;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import ir.iraniancyber.khaneshyar.repository.UserRepository;
import ir.iraniancyber.khaneshyar.service.category.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServiceImpl(UserRepository userRepository,PostRepository postRepository, CategoryRepository categoryRepository) {
        this.postRepository = postRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository=userRepository;
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
    @Override
    public List<PostAdmin> findAll()
    {
        List<Post> list=postRepository.findAll();
        List<PostAdmin> postAdmins=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Post post=list.get(i);
            postAdmins.add(new PostAdmin(post.getId(),post.getTitle(),post.getSlug(),post.getExcerpt(),post.getStatus(),post.getAuthor().getId(),post.getCreatedAt(),post.getUpdateAt(),post.getPublishAt(),post.getViews(),post.getCategory().getName()));
        }
        return postAdmins;
    }
    @Override
    public void delete(int id)
    {
        postRepository.deleteById(id);
    }
    @Override
    public void add(HttpServletRequest request) {
        Post post=new Post();
        post.setViews(0);
        post.setAuthor(userRepository.findByUsername(request.getUserPrincipal().getName()).get());
        post.setCategory(categoryRepository.findAll().get(0));
        post.setContent("<p>این صفحه خالی است.</p>");
        post.setSlug("slug");
        post.setCreatedAt(LocalDateTime.now());
        post.setExcerpt("توضیحات وبلاگ");
        post.setPublishAt(LocalDateTime.now());
        post.setTitle("عنوان");
    }
    @Override
    public Optional<Post> findById(int id)
    {
        return postRepository.findById(id);
    }
    @Override
    public void update(Post post,int categoryId)
    {
        post.setCategory(categoryRepository.findById(categoryId).get());
        postRepository.save(post);
    }
}
