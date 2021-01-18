package com.elenakuropatkina.services;

import com.elenakuropatkina.controllers.ProductRepresent;
import com.elenakuropatkina.exeptions.NotFoundException;
import com.elenakuropatkina.models.Product;
import com.elenakuropatkina.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService, Serializable {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductRepresent> findAll() {
        return productRepository.findAll().stream()
                .map(ProductRepresent::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Optional<ProductRepresent> findById(Long id) {
        return productRepository.findById(id).map(ProductRepresent::new);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(ProductRepresent productRepresent){
        Product product = (productRepresent.getId() != null) ? productRepository.findById(productRepresent.getId())
                .orElseThrow(NotFoundException::new) : new Product();
        product.setTitle(productRepresent.getTitle());
        product.setCategory(productRepresent.getCategory());
        product.setBrand(productRepresent.getBrand());
        product.setPrice(productRepresent.getPrice());

        productRepository.save(product);
    }
}
