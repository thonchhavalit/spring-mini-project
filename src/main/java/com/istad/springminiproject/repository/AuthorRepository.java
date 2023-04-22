package com.istad.springminiproject.repository;


import com.istad.springminiproject.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>(){{
        add(new Author(1001,"Thon Chhavalit","valit","https://th.bing.com/th/id/OIP.SdB_qPhbKS73WKzeP25VOgHaK9?w=184&h=273&c=7&r=0&o=5&dpr=1.3&pid=1.7","male","Kratie","thonchhavalit@gmail.com"));
        add(new Author(1002,"Nhoeb Chanveasna","veasna","https://th.bing.com/th/id/OIP.2FF3D8p5y6UraON6wZkCUAHaKb?w=184&h=260&c=7&r=0&o=5&dpr=1.3&pid=1.7","male","Kompong Cham","veasnachan@gmail.com"));
        add(new Author(1003,"Ngan Vidy","vidy","https://th.bing.com/th/id/OIP.KRKoCO4j5h_AF2DAFBKkQwHaNK?w=184&h=328&c=7&r=0&o=5&dpr=1.3&pid=1.7","male","Takeo","vidyngan@gmail.com"));
        add(new Author(1004,"San Sinaro","naro","https://th.bing.com/th/id/OIP.uPVSm_gXKL3e7Wn2CwQyKQHaJQ?w=184&h=230&c=7&r=0&o=5&dpr=1.3&pid=1.7","male","Preah Vihear","sinarosan@gmail.com"));
    }};
   public List<Author> getAllAuthors(){
        return authors;
    }
    public List<Author> getArticleAllAuthor(int id) {
        return authors.stream()
                .filter(el -> el.getId() == id)
                .collect(Collectors.toList());
    }
}
