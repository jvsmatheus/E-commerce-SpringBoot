package br.com.matheus.naturaSSP.services.product;

import br.com.matheus.naturaSSP.models.Category;
import br.com.matheus.naturaSSP.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface IProductService {

    Product createProduct(Product product);

    Product updateProduct(Product product);
    ArrayList<Product> findAll();
    ArrayList<Product> findAllAvailable();
    ArrayList<Product> findAllByCategory(Category category);
    ArrayList<Product> findAllByUnavailable();
    Product findById(int id);
}
