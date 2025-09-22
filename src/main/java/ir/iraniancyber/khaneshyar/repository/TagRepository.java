package ir.iraniancyber.khaneshyar.repository;

import ir.iraniancyber.khaneshyar.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Integer> {
    List<Tag> findAllByPostId(int id);
}
