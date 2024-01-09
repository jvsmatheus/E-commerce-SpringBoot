package br.com.matheus.naturaSSP.dao;

import br.com.matheus.naturaSSP.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    ArrayList<Category> findByNameContaining(String keyWord);
}
