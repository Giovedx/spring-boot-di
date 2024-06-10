package com.geo.springboot.di.app.repositories;

import com.geo.springboot.di.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository
{
    @Override
    public List<Product> findAll()
    {
        return Collections.singletonList(new Product(1L,"Monitor Asus 27", 600L));
    }

    @Override
    public
    Product findById(Long id)
    {
         return new Product(id,"Monitor Asus 27",600L);
    }



}
