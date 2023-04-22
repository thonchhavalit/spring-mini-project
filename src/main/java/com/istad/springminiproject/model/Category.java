package com.istad.springminiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private int categoryID;
    private int id;
    private String category;
    private String categoryDescription;
}
