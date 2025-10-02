package ir.iraniancyber.khaneshyar.service.tag;

import ir.iraniancyber.khaneshyar.dto.tag.TagAdmin;
import ir.iraniancyber.khaneshyar.dto.tag.TagDto;
import ir.iraniancyber.khaneshyar.dto.tag.TagSaveAndGet;
import ir.iraniancyber.khaneshyar.model.Tag;
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
    @Override
    public List<TagAdmin> findAll()
    {
        List<Tag> tags=tagRepository.findAll();
        List<TagAdmin> tagAdmins=new ArrayList<>();
        for(int i=0;i<tags.size();i++)
        {
            Tag tag=tags.get(i);
            tagAdmins.add(new TagAdmin(tag.getId(),tag.getName(),tag.getSlug(),tag.getPost().getId()));
        }
        return tagAdmins;
    }
    @Override
    public void delete(int id)
    {
        tagRepository.deleteById(id);
    }
    @Override
    public void add()
    {
        Tag tag=new Tag();
        tag.setName("تگ");
        tag.setSlug("tag");
        tag.setPost(postRepository.findAll().get(0));
        tagRepository.save(tag);
    }
    @Override
    public void update(Tag tag,int postId)
    {
        tag.setPost(postRepository.findById(postId).get());
        tagRepository.save(tag);
    }
    @Override
    public Tag findById(int id)
    {
        return tagRepository.findById(id).get();
    }
    @Override
    public TagSaveAndGet findTagAdminById(int id)
    {
        Tag tag=tagRepository.findById(id).get();
        return new TagSaveAndGet(tag.getId(),tag.getName(),tag.getSlug(),tag.getPost().getId());
    }
}
