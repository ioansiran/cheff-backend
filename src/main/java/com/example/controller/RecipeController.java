package com.example.controller;

import com.example.beans.Dummy;
import com.example.dao.RecipeServiceImpl;
import com.example.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ioan Siran on 4/5/2017.
 */
@RestController
public class RecipeController {
    private final Dummy dummy;
    private RecipeServiceImpl recipeService = new RecipeServiceImpl();

    @Autowired
    public RecipeController(Dummy dummy) {
        this.dummy = dummy;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        return recipeService.getAll();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getRecipeCount() {
        return recipeService.getCount();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        com.example.entities.Recipe byId = recipeService.getById(id);
        return new ResponseEntity<Recipe>(byId, byId == null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        recipeService.save(recipe);
        return new ResponseEntity<Recipe>(HttpStatus.ACCEPTED);
    }

}
