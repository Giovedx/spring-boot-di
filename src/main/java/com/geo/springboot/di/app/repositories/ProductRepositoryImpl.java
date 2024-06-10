package com.geo.springboot.di.app.repositories;

import com.geo.springboot.di.app.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Arrays;
import java.util.List;


@Primary
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository
{
    private List<Product> data;

    public ProductRepositoryImpl()
    {
        this.data = Arrays.asList(

            new Product(1L,"Memoria corsair 32" ,300L),
            new Product(2L,"Cpu Intel Core i9",850L),
            new Product(3L,"Teclado Razer Mini 60%",180L),
            new Product(4L,"MotherBoard Gigabyte",490L)

        );
    }

    @Override
    public List<Product> findAll()
    {
        return data;
    }

    @Override
    public Product findById(Long id)
    {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
