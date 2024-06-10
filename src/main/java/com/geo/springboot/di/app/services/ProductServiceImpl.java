package com.geo.springboot.di.app.services;

import com.geo.springboot.di.app.models.Product;
import com.geo.springboot.di.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements  ProductService
{



    private Environment environment;

    @Value("${config.prince.tax}")
    private Double tax;
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository, Environment environment)
    {
        this.repository = repository;
        this.environment = environment;
    }

    @Override
    public List<Product> findAll()
    {
        return repository.findAll().stream().map(p -> {

            Double priceTax = p.getPrice() * tax;

            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;


        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id)
    {

        return repository.findById(id);
    }



}
