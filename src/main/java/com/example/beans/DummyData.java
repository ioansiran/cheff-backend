package com.example.beans;

import com.example.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 4/5/2017.
 */
@Component
public class DummyData implements Dummy {
    private List<Recipe> dummyData;

    public DummyData() {
        dummyData = new ArrayList<>();
        dummyData.add(new Recipe(0, "Pasta", "Pastele se fierb in apa", 1023413, new String[]{"flour", "corn", "water"}, new String[]{"80g", "20g", "1l"}, "pasta.jpg"));
        dummyData.add(new Recipe(1, "Barbecue", "Chicken is roasted on fire", 1023413, new String[]{"chicken", "oregano", "salt"}, new String[]{"80g", "20g", "1l"}, "barbecue.jpg"));
        dummyData.add(new Recipe(2, "Pizza", "Peperoni is put on the dough", 1023413, new String[]{"ketchup", "dough", "cheese"}, new String[]{"80g", "20g", "100g"}, "pizza.jpg"));
    }

    @Override
    public List<Recipe> getData() {
        return dummyData;
    }
}
