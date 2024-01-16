package br.com.matheus.naturaSSP.services.category;

import br.com.matheus.naturaSSP.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ICategoryService {

    // Recebe uma categoria e só com o nome preenchido e salva no banco
    Category createCategory(Category category);

    // Altera a categoria existente, retorna null caso contrário
    Category updateCategory(Category category);

    // Retorna todas as categorias
    ArrayList<Category> findAllCategories();

    // Retorna uma categoria específica
    ArrayList<Category> findByKeyWord(String keyWord);
}
