package com.istad.springminiproject.service;



import com.istad.springminiproject.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    List<Author> findByCategory(int ids);
}
