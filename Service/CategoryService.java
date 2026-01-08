package com.crud.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Model.Category;
import com.crud.Repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
    private CategoryRepo categoryRepo;

    // 1. Get All
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    // 2. Get By Id
    public Category getCategoryById(long id) throws Exception {
        Category data = categoryRepo.findById(id)
                .orElseThrow(() -> new Exception("Category ID " + id + " not present!!"));
        return data;
    }

    // 3. Add New (Using standard save)
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    // 4. Update
    public Category updateCategory(long id, Category data) throws Exception {
        // Find existing record
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new Exception("ID not present!!"));
        
        // Update fields
        category.setCId(id);
        category.setName(data.getName());
        
        // Save and return
        return categoryRepo.save(category);
    }

    // 5. Delete
    public Category deleteCategory(long id) throws Exception {
        Category data = categoryRepo.findById(id)
                .orElseThrow(() -> new Exception("Cannot delete, ID not found"));
        
        categoryRepo.deleteById(id);
        return data; // Returning the deleted object info
    }
	
}
