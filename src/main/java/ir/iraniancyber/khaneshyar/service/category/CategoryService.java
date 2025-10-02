package ir.iraniancyber.khaneshyar.service.category;

import ir.iraniancyber.khaneshyar.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void add();
    void delete(int id);
    void update(Category category);
    Category findCategoryById(int id);
}
