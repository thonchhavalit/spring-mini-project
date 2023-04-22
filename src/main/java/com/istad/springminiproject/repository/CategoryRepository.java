package com.istad.springminiproject.repository;


import com.istad.springminiproject.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryRepository {
    List<Category> categories = new ArrayList<>(){{
       add(new Category(1,1001,"News","Better to have bad news that's true than good news we made up"));
        add(new Category(2,1002,"Funny","I'm sick of following my dreams, man. I'm just going to ask where they're going and hook up with ’em later."));
        add(new Category(3,1003,"Entertainment","The highest goal of music is to connect one's soul to their Divine Nature, not entertainment"));
        add(new Category(5,1005,"Education","Education is not the filling of a pot but the lighting of a fire."));
        add(new Category(6,1006,"programming","I'm not a great programmer; I'm just a good programmer with great habits."));
    }};
   public List<Category> getAllCategories(){
        return categories;
    }
}
