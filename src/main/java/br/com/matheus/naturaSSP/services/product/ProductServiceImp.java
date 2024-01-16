package br.com.matheus.naturaSSP.services.product;

import br.com.matheus.naturaSSP.dao.ProductDAO;
import br.com.matheus.naturaSSP.models.Category;
import br.com.matheus.naturaSSP.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component
public class ProductServiceImp implements IProductService {

    @Autowired
    private ProductDAO dao;

    @Override
    public Product createProduct(Product product) {
        try {
            dao.save(product);
            return product;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            dao.save(product);
            return product;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Product> findAll() {
        return (ArrayList<Product>) dao.findAll();
    }

    @Override
    public ArrayList<Product> findAllAvailable() {
        return dao.findAllByAvailable(true);
    }

    @Override
    public ArrayList<Product> findAllByCategory(Category category) {
        return dao.findAllByAvailableAndCategory(true, category);
    }

    @Override
    public ArrayList<Product> findAllByUnavailable() {
        return dao.findAllByAvailable(false);
    }

    @Override
    public Product findById(int id) {
        return dao.findById(id).orElse(null);
    }


}
