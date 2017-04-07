package com.example.dao;

import com.example.entities.Recipe;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


/**
 * Created by ioan on 07.04.2017.
 */
public class RecipeServiceImpl implements RecipeService {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Override
    public void save(Recipe recipe) {
        getSession().save(recipe);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Recipe> getAll() {
        return getSession().createQuery("from Recipe").list();
    }

    @Override
    public int getCount() {
        return ((Long) getSession().createQuery("select count(*) from Recipe").uniqueResult()).intValue();
    }

    public Recipe getById(int id) {
        return getSession().get(Recipe.class, id);
    }
}
