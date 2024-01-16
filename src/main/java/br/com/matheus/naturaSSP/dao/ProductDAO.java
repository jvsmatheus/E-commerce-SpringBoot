package br.com.matheus.naturaSSP.dao;

import br.com.matheus.naturaSSP.models.Category;
import br.com.matheus.naturaSSP.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {

    ArrayList<Product> findAllByCategory(Category category);
    ArrayList<Product> findAllByAvailable(Boolean available);
    ArrayList<Product> findAllByAvailableAndCategory(Boolean available, Category category);
}
