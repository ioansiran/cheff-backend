package com.example.model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by PC on 4/5/2017.
 */
public class Recipe {
    private int id;
    private String name;
    private String content;
    private int duration;
    private String[] ingredients;
    private String[] weights;
    private String picture;

    public Recipe(int id, String name, String content, int duration, String[] ingredients, String[] weights, String picture) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.duration = duration;
        this.ingredients = ingredients;
        this.weights = weights;
        this.picture = picture;
    }

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String[] getWeights() {
        return weights;
    }

    public void setWeights(String[] weights) {
        this.weights = weights;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", duration=" + duration +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", weights=" + Arrays.toString(weights) +
                ", picture='" + picture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id &&
                duration == recipe.duration &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(content, recipe.content) &&
                Arrays.equals(ingredients, recipe.ingredients) &&
                Arrays.equals(weights, recipe.weights) &&
                Objects.equals(picture, recipe.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, duration, ingredients, weights, picture);
    }
}
