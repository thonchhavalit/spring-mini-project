package com.istad.springminiproject.service.implement;


import com.istad.springminiproject.model.Author;
import com.istad.springminiproject.repository.AuthorRepository;
import com.istad.springminiproject.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServiceImp implements AuthorService {
     @Autowired
     AuthorRepository authorRepository;
    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthors();
    }

    @Override
    public List<Author> findByCategory(int ids) {
        return authorRepository.getArticleAllAuthor(ids);
    }
}
