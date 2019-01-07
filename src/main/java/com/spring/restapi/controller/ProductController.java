package com.spring.restapi.controller;

import com.spring.restapi.models.Product;
import com.spring.restapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/all")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @PostMapping
    public String save(@RequestBody Product product) {
        productRepository.save(product);

        return product.getId();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable("id") String id) {
        return productRepository.getById(id);
    }

    @GetMapping("/price/{maxProdPrice}")
    public List<Product> getPrice(@PathVariable("maxProdPrice") double prodPrice) {
        return productRepository.findByProdPriceLessThan(prodPrice);
    }

    @GetMapping("/search/{prodName}")
    public List<Product> getByName(@PathVariable("prodName") String prodName) {
        return (List<Product>) productRepository.findByProdNameContains(prodName);
    }

    /*@GetMapping("/")
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    public Product show(@PathVariable String id) {
        return productRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Product prod = productRepository.findOne(id);
        if (product.getProdName() != null)
            prod.setProdName(product.getProdName());
        if (product.getProdDesc() != null)
            prod.setProdDesc(product.getProdDesc());
        if (product.getProdPrice() != null)
            prod.setProdPrice(product.getProdPrice());
        if (product.getProdImage() != null)
            prod.setProdImage(product.getProdImage());
        productRepository.save(prod);
        return prod;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public String delete(@PathVariable String id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product);

        return "product deleted";
    }*/
}
