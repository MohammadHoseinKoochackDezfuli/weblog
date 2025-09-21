package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.model.Category;
import ir.iraniancyber.khaneshyar.service.category.CategoryService;
import ir.iraniancyber.khaneshyar.service.post.PostService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/findAll")
    public List<Category> findAll()
    {
        return categoryService.findAll();
    }
}
