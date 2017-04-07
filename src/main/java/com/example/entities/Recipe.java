package com.example.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ioan on 07.04.2017.
 */
@Entity
public class Recipe {
    private int id;
    private String name;
    private String content;
    private int duration;
    private String picture;
    private List<Ingredient> ingredientsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 1024)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 32)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        if (id != recipe.id) return false;
        if (duration != recipe.duration) return false;
        if (name != null ? !name.equals(recipe.name) : recipe.name != null) return false;
        if (content != null ? !content.equals(recipe.content) : recipe.content != null) return false;
        return picture != null ? picture.equals(recipe.picture) : recipe.picture == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "recipeByRecipeId")
    public List<Ingredient> getIngredientsById() {
        return ingredientsById;
    }

    public void setIngredientsById(List<Ingredient> ingredientsById) {
        this.ingredientsById = ingredientsById;
    }
}
