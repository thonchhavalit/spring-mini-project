package com.istad.springminiproject.service.implement;


import com.istad.springminiproject.model.Category;
import com.istad.springminiproject.repository.CategoryRepository;
import com.istad.springminiproject.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
}
