package ir.iraniancyber.khaneshyar.service.tag;

import ir.iraniancyber.khaneshyar.dto.tag.TagAdmin;
import ir.iraniancyber.khaneshyar.dto.tag.TagDto;
import ir.iraniancyber.khaneshyar.dto.tag.TagSaveAndGet;
import ir.iraniancyber.khaneshyar.model.Tag;

import java.util.List;

public interface TagService {
    List<TagDto> findAllByPostId(String slug);
    List<Tag> findAllBySlug(String slug);
    List<TagAdmin> findAll();
    void delete(int id);
    void add();
    void update(Tag tag,int postId);
    Tag findById(int id);
    TagSaveAndGet findTagAdminById(int id);
}
