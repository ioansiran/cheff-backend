package com.example.controller;

import com.example.beans.Dummy;
import com.example.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by PC on 4/5/2017.
 */
@RestController
public class RecipeController {
    @Autowired
    private Dummy dummy;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Recipe> getAllRecipes() {
        return dummy.getData();
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public int getRecipeCount() {
        return dummy.getData().size();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        Optional<Recipe> r = dummy.getData().stream().filter(recipe -> recipe.getId() == id).findFirst();
        return r.isPresent() ? new ResponseEntity<Recipe>(r.get(), HttpStatus.OK) : new ResponseEntity<Recipe>(new Recipe(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/from/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getRecipeStartingFrom(@PathVariable int id) {
        List<Recipe> r = dummy.getData().stream().filter(recipe -> recipe.getId() >= id).collect(Collectors.toList());
        return new ResponseEntity<List<Recipe>>(r, r.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}