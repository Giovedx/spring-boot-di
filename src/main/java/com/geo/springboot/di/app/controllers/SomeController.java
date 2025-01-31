package com.geo.springboot.di.app.controllers;


import com.geo.springboot.di.app.models.Product;
import com.geo.springboot.di.app.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SomeController
{
      @Autowired
      private ProductService service;
      @GetMapping
      public List<Product> list()
      {
          return service.findAll();
      }

      @GetMapping("/{id}")
      public Product show(@PathVariable long id)
      {
           return service.findById(id);
      }

}
