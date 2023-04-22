package com.istad.springminiproject.repository;


import com.istad.springminiproject.model.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ArticleRepository {
    List<Article> articles = new ArrayList<>(){{
        add(new Article(1, 1001,"I love Entertainment","https://th.bing.com/th/id/OIP.9A8Xf1xIKgfU4gwpaKzAzAHaEo?w=294&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7","The highest goal of music is to connect one's soul to their Divine Nature, not entertainment",new AuthorRepository().getAllAuthors().get(0),new CategoryRepository().getAllCategories().get(0)));
        add(new Article(2,1002,"I love Programming","https://th.bing.com/th/id/OIP.fUw-qMBinJErrhO0nf-LUwHaEK?w=289&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7"," I'm not a great programmer; I'm just a good programmer with great habits.",new AuthorRepository().getAllAuthors().get(1),new CategoryRepository().getAllCategories().get(1)));
        add(new Article(3,1003,"I love Funny","https://th.bing.com/th/id/OIP.UGe0hDgOlhZCZJhjMiiCjwHaEK?w=290&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7","I'm sick of following my dreams, man. I'm just going to ask where they're going and hook up with ’em later.\"",new AuthorRepository().getAllAuthors().get(2),new CategoryRepository().getAllCategories().get(2)));
        add(new Article(4,1004,"I love Education","https://th.bing.com/th/id/OIP.-T12PgBozYqVmiQYQ36heQHaE8?w=273&h=182&c=7&r=0&o=5&dpr=1.3&pid=1.7","Education is not the filling of a pot but the lighting of a fire.",new AuthorRepository().getAllAuthors().get(3),new CategoryRepository().getAllCategories().get(0)));
    }};
    public List<Article> getAllArticles(){
        return articles;
    }
   public Article getArticleById(int id){
        return articles.stream().filter(el->el.getId()==id).findFirst().orElse(null);
    }
    public List<Article> getArticleAllAuthor(int ids) {
        return articles.stream()
                .filter(el -> el.getId() == ids)
                .collect(Collectors.toList());
    }
    public void addNewUser(Article article){
        articles.add(article);
    }
   public void deleteArticle(int id) {
       for (int i = 0; i < articles.size(); i++) {
           Article article = articles.get(i);
           if (article.getArticleID() == id) {
               articles.remove(i);
           }
       }
    }

       public void updateArticle(int id,Article article) {
           for (int i = 0; i < articles.size(); i++) {
                article = articles.get(i);
               if (article.getArticleID() == id) {
                   articles.set(i,article);
               }
           }
       }

}
