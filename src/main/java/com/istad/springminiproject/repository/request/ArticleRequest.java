package com.istad.springminiproject.repository.request;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
    @NotEmpty(message = "Title Can't be empty.")
    private String title;
    private int id;
    @NotEmpty(message = "Description Can't be empty.")
    private String description;
    private int authorId;
    private int categoryId;

}
