package ir.iraniancyber.khaneshyar.service.category;

import ir.iraniancyber.khaneshyar.model.Category;
import ir.iraniancyber.khaneshyar.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    @Override
    public void add()
    {
        Category category=new Category();
        category.setName("کتگوری");
        category.setSlug("category");
        category.setDescription("توضیحات کتگوری");
        categoryRepository.save(category);
    }
    @Override
    public void delete(int id)
    {
        categoryRepository.deleteById(id);
    }
    @Override
    public void update(Category category)
    {
        categoryRepository.save(category);
    }
    @Override
    public Category findCategoryById(int id)
    {
        return categoryRepository.findById(id).get();
    }
}
