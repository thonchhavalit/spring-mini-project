package com.istad.springminiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int articleID;
    private int id;
    private String title;
    private String imageURL;
    private String article;
    private Author author;
    private Category category;
}


// post -> author
// findAll post that belong to author with id = 1001