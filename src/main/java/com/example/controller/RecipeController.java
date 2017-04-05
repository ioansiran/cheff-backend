package com.example.controller;

import com.example.model.Recipe;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 4/5/2017.
 */
@RestController
public class RecipeController {
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        return new ArrayList<>();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getRecipeCount() {
        return 0;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Recipe getRecipe(@PathVariable int id) {
        return new Recipe();

    }

    @RequestMapping(value = "/from/{id}", method = RequestMethod.GET)
    public List<Recipe> getRecipeStartingFrom(@PathVariable int id) {
        return new ArrayList<>();
    }
}
