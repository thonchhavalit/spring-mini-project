package com.istad.springminiproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private int authorId;
    private String name;
    private String username;
    private String profileImage;
    private String gender;
    private String address;
    private String email;

}
