package br.com.matheus.naturaSSP.services;

import br.com.matheus.naturaSSP.dao.CategoryDAO;
import br.com.matheus.naturaSSP.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component // Para ser injetável no código
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryDAO dao;

    @Override
    public Category createCategory(Category category) {
        try {
            if (category.getName() != null && category.getName().trim().length() > 0) {
                dao.save(category);
                return category;
            }
        }
        catch (IllegalArgumentException ex) {
            System.out.println("DEBUG: " + ex.getMessage());
        }
        catch (Exception ex) {
            System.out.println("DEBUG: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        try {
            if(category.getId() != null && category.getName() != null && category.getName().trim().length() != 0) {
                dao.save(category);
                return category;
            }
        }
        catch (Exception ex) {
            System.out.println("DEBUG: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Category> findAllCategories() {
        return (ArrayList<Category>) dao.findAll();
    }

    @Override
    public ArrayList<Category> findByKeyWord(String keyWord) {
        if (keyWord != null) {
            return dao.findByNameContaining(keyWord);
        }
        return null;
    }
}
