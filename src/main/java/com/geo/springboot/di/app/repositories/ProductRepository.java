package com.geo.springboot.di.app.repositories;

import com.geo.springboot.di.app.models.Product;

import java.util.List;

public interface ProductRepository
{
    List<Product> findAll();
    Product findById(Long id);

}
