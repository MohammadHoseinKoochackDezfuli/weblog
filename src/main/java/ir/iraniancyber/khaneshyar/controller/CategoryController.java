package ir.iraniancyber.khaneshyar.controller;

import ir.iraniancyber.khaneshyar.dto.tag.TagSaveAndGet;
import ir.iraniancyber.khaneshyar.model.Category;
import ir.iraniancyber.khaneshyar.model.Tag;
import ir.iraniancyber.khaneshyar.service.category.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void delete(@RequestParam int id) {
        categoryService.delete(id);
    }

    @GetMapping("/add")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void add() {
        categoryService.add();
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public void update(@RequestBody Category data) {
        categoryService.update(data);
    }

    @GetMapping("/findAdminById")
    public Category findTagAdminById(@RequestParam int id) {
        return categoryService.findCategoryById(id);
    }
}
