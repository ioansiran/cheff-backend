package com.example.dao;

import com.example.entities.Recipe;

import java.util.List;

/**
 * Created by ioan on 07.04.2017.
 */
public interface RecipeService {
    void save(Recipe recipe);

    List<Recipe> getAll();

    int getCount();
}
