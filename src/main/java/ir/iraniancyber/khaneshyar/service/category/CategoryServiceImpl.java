package ir.iraniancyber.khaneshyar.service.category;

import ir.iraniancyber.khaneshyar.model.Category;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll()
    {
        return categoryRepository.findAll();
    }
}
