package com.example.challenge_spring.service;

import com.example.challenge_spring.dto.ProductDto;
import com.example.challenge_spring.exceptions.CategoryNotFoundException;
import com.example.challenge_spring.model.Product;
import com.example.challenge_spring.repository.ProductRepo;
import com.example.challenge_spring.util.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepo repository;
    
    // Método que cadastra um produto, gerando um id a partir do tamanho da lista.
    @Override
    public ProductDto createProduct(Product product) throws IOException {
        int id = repository.getAll().size();
        product.setProductId(id + 1);
        return new ProductDto(repository.saveProduct(product));
    }

    @Override
    public List<ProductDto> createProducts(List<Product> products) throws IOException {
        int id = repository.getAll().size();
        for(Product product : products){  // for each
            product.setProductId(++id); // interando produto a produto e setando o Id um por um
        }
        //Pega a lista retornada pelo repository apos salvar, e transforma em uma lista de ProductDto
        // map pega a lsita de produtos um por um e por metodo por referencia transforma em Product DTO
        return repository.saveProducts(products).stream().map(ProductDto::new).collect(Collectors.toList());

    }

    @Override
    public List<Product> getAll() {
        return repository.getAll();
    }

    // Método que filtra produtos por categoria
    @Override
    public List<Product> getAllByCategory(String category) {
        List<Product> products = getAll();

        List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        if (filteredProducts.isEmpty()) {
            throw new CategoryNotFoundException("Nenhum produto encontrado para esta categoria");
        }
        return filteredProducts;
    }

    // Método que filtra produtos por categoria e frete
    @Override
    public List<Product> getAllByCategoryAndShipping(String category, boolean freeShipping) {
        List<Product> productsByCategory = getAllByCategory(category);

        return productsByCategory.stream()
                .filter(product -> product.isFreeShipping() == freeShipping)
                .collect(Collectors.toList());
    }

    // Método que filtra produtos por frete e avaliação
    @Override
    public List<Product> getAllByShippingAndPrestige(boolean freeShipping, String prestige) {
        List<Product> products = getAll();

        return products.stream()
                .filter(product -> product.isFreeShipping() == freeShipping &&
                        product.getPrestige().equals(prestige))
                .collect(Collectors.toList());
    }

    // Método que ordena produtos filtrados por categoria e frete
    @Override
    public List<Product> getAllByCategoryAndShippingOrdered(String category, boolean freeShipping, int order) {
        List<Product> products = getAllByCategoryAndShipping(category, freeShipping);

        return products.stream()
                .sorted((p1, p2) -> ProductOrder.orderProducts(order, p1, p2))
                .collect(Collectors.toList());
    }
}
