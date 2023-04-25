package com.istad.springminiproject.controller;


import com.istad.springminiproject.model.Article;
import com.istad.springminiproject.model.Author;
import com.istad.springminiproject.model.Category;
import com.istad.springminiproject.repository.request.ArticleRequest;
import com.istad.springminiproject.service.ArticleService;
import com.istad.springminiproject.service.AuthorService;
import com.istad.springminiproject.service.CategoryService;
import com.istad.springminiproject.service.UploadFileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Comparator;
import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    CategoryService categoryService;
    AuthorService authorService;
    UploadFileService uploadFileService;
    ArticleController(
            ArticleService articleService,
            AuthorService authorService,
            CategoryService categoryService,
            UploadFileService uploadFileService
    ){
        this.articleService =articleService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.uploadFileService = uploadFileService;
    }
    @GetMapping("/homepage")
   public String homePage(Model model){
//        List<Article> articles = articleService.getAllArticle();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("article",articleService.getAllArticle().stream().sorted((a,b)->b.getArticleID()-a.getArticleID()));
        model.addAttribute("category",categories);
        return "home";
    }
    @GetMapping("/all-user")
    public String allUser(Model model){
        List<Article> articles = articleService.getAllArticle();
        model.addAttribute("article",articles);
        return "all-users";
    }
    @GetMapping("/all-user/{id}")
    public String allUser(@PathVariable("id") int id, Model model){
        List<Article> find=articleService.getAllAuthor(id);
        System.out.println("result :"+find);
        model.addAttribute("article",find);
        return "all-users";
    }
    @GetMapping("/my-profile/{id}")
    public String myProfile(@PathVariable("id") int id,Model model){
       Article article = articleService.getArticleById(id);
       List<Article> findProfile=articleService.getAllAuthor(id);
        model.addAttribute("article",article);
        model.addAttribute("lastArticle",findProfile);
        return "my-profile";
    }
    @GetMapping("/create-post")
    public String getAddNew(Model model){
        List<Author> authors= authorService.getAllAuthor();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("article",new ArticleRequest());
        model.addAttribute("author", authors);
        model.addAttribute("category",categories);
        return "create-post";
    }
    @PostMapping("/AddArticle")
    String handAddArticle(@Valid @ModelAttribute("article") ArticleRequest article, BindingResult bindingResult, @RequestParam("file")MultipartFile file, Model model){

     if(bindingResult.hasErrors()){
         System.out.println("Error Happened!!");
         model.addAttribute("authors",authorService.getAllAuthor());
         model.addAttribute("category",categoryService.getAllCategories());
         return "create-post";
     }
        Article newArticle = new Article();
        try {
            String fileName = "http://localhost:8080/images/"+uploadFileService.fileUpload(file);
            newArticle.setImageURL(fileName);
            System.out.println("The File name is :  "+fileName);
        }catch (Exception ex){
            newArticle.setImageURL("https://developers.elementor.com/docs/assets/img/elementor-placeholder-image.png");
            System.out.println("Error"+ex.getMessage());
        }
        newArticle.setTitle(article.getTitle());
        newArticle.setArticle(article.getDescription());
        newArticle.setId(article.getAuthorId());
        newArticle.setAuthor(authorService.getAllAuthor().stream().filter(e -> e.getAuthorId() == article.getAuthorId())
                .findFirst().orElse(null));
        newArticle.setCategory(categoryService.getAllCategories().stream().filter(el->el.getId()==article.getCategoryId())
                .findFirst().orElse(null));
        newArticle.setArticleID(articleService.getAllArticle().stream().max(Comparator.comparingInt(Article::getArticleID)).orElseThrow().getArticleID() + 1);
        System.out.println("article is : "+newArticle);
        articleService.addNewArticle(newArticle);
        return "redirect:/homepage";

    }
    @GetMapping("/deleteId/{id}")
    String deleteById(@PathVariable("id") int id,Model model){
         articleService.deleteById(id);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("article",articleService.getAllArticle().stream().sorted((a,b)->b.getArticleID()-a.getArticleID()));
        model.addAttribute("category",categories);
      return "home";
    }
}