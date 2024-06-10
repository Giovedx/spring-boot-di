package com.geo.springboot.di.app.services;

import com.geo.springboot.di.app.models.Product;

import java.util.List;

public interface ProductService
{
    List<Product> findAll();
    Product findById(Long id);

}
