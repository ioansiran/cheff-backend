package com.example.controller;

import com.example.beans.Dummy;
import com.example.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Ioan Siran on 4/5/2017.
 */
@RestController
public class RecipeController {
    private final Dummy dummy;

    @Autowired
    public RecipeController(Dummy dummy) {
        this.dummy = dummy;
    }

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
        return new ResponseEntity<>(r.orElseGet(Recipe::new), r.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/from/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getRecipeStartingFrom(@PathVariable int id) {
        List<Recipe> r = dummy.getData().stream().filter(recipe -> recipe.getId() >= id).collect(Collectors.toList());
        return new ResponseEntity<>(r, r.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        if (!dummy.getData().contains(recipe)) {
            dummy.getData().add(recipe);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        } else
            return new ResponseEntity<>(recipe, HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/update/", method = RequestMethod.PUT)
    public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe recipe) {
        dummy.getData().removeIf(recipe1 -> recipe1.getId() == recipe.getId());
        dummy.getData().add(recipe);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteRecipe(@PathVariable int id) {
        dummy.getData().removeIf((recipe -> recipe.getId() == id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
