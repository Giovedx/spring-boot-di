package com.geo.springboot.di.app;


import com.geo.springboot.di.app.repositories.ProductRepository;
import com.geo.springboot.di.app.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig
{

     @Value("classpath:json/product.json")
     private Resource resource;

     @Bean("productJson")
     public ProductRepository productRepositoryJson()
     {
         return new ProductRepositoryJson(resource);
     }

}
