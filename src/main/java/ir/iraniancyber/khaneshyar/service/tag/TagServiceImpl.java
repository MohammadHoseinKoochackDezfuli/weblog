package ir.iraniancyber.khaneshyar.service.tag;

import ir.iraniancyber.khaneshyar.dto.TagDto;
import ir.iraniancyber.khaneshyar.model.Tag;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import ir.iraniancyber.khaneshyar.repository.PostRepository;
import ir.iraniancyber.khaneshyar.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }
    @Override
    public List<TagDto> findAllByPostId(String slug)
    {
        int id = postRepository.findBySlug(slug).get().getId();
        List<Tag> list=tagRepository.findAllByPostId(id);
        List<TagDto> dtoList=new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            Tag tag=list.get(i);
            dtoList.add(new TagDto(tag.getName(),tag.getSlug()));
        }
        return dtoList;
    }
    @Override
    public List<Tag> findAllBySlug(String slug)
    {
        return tagRepository.findAllBySlug(slug);
    }
}
