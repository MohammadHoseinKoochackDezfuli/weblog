package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.TagDto;
import ir.iraniancyber.khaneshyar.model.Tag;
import ir.iraniancyber.khaneshyar.service.post.PostService;
import ir.iraniancyber.khaneshyar.service.tag.TagService;
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
    public List<TagDto> findAllByPostId(@RequestParam String slug)
    {
        return tagService.findAllByPostId(slug);
    }
}
