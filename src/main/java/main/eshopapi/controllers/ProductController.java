package main.eshopapi.controllers;

import main.eshopapi.repositories.IProductRepository;

public class ProductController {

    private final IProductRepository productRepository;

    public ProductController(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }


}
