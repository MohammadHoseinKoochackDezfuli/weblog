package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.tag.TagAdmin;
import ir.iraniancyber.khaneshyar.dto.tag.TagDto;
import ir.iraniancyber.khaneshyar.dto.tag.TagSaveAndGet;
import ir.iraniancyber.khaneshyar.model.Tag;
import ir.iraniancyber.khaneshyar.service.tag.TagService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/findAllByPostId")
    public List<TagDto> findAllByPostId(@RequestParam String slug) {
        return tagService.findAllByPostId(slug);
    }

    @GetMapping("/findAllBySlug")
    public List<Tag> findAllBySlug(@RequestParam String slug) {
        return tagService.findAllBySlug(slug);
    }

    @GetMapping("/findAll")
    public List<TagAdmin> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id) {
        tagService.delete(id);
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void add() {
        tagService.add();
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void update(@RequestBody TagSaveAndGet data) {
        Tag tag = tagService.findById(data.getId());
        tag.setName(data.getName());
        tag.setSlug(data.getSlug());
        tagService.update(tag, data.getPostId());
    }

    @GetMapping("/findAdminById")
    public TagSaveAndGet findTagAdminById(@RequestParam int id) {
        return tagService.findTagAdminById(id);
    }
}
