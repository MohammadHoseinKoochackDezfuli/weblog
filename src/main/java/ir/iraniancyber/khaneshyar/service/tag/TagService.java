package ir.iraniancyber.khaneshyar.service.tag;

import ir.iraniancyber.khaneshyar.dto.TagDto;
import ir.iraniancyber.khaneshyar.model.Tag;
import org.springframework.core.metrics.StartupStep;

import java.util.List;

public interface TagService {
    List<TagDto> findAllByPostId(String slug);
}
