package com.istad.springminiproject.service;



import com.istad.springminiproject.model.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticle();
    Article getArticleById(int id);
    List<Article> getAllAuthor(int id);
    void addNewArticle(Article article);
    void deleteById(int id);
    void updateArticleById(int id,Article article);
}
