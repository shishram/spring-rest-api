package com.spring.restapi.repositories;

import com.spring.restapi.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    Product getById(String id);

    List<Product> findByProdPriceLessThan(double prodPrice);

    @Query(value = "{prodName: ?0}")
    List<Product> findByProdNameContains(String prodName);


}

