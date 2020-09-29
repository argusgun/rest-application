package com.example.restapplication.services;

import com.example.restapplication.entetities.Product;
import com.example.restapplication.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProduct(Long id){
        return productRepo.findById(id).get();
    }

    public void saveProduct(Product product){
        productRepo.save(product);
    }

    public void deleteProduct(Long id){
        productRepo.deleteById(id);
    }
}
