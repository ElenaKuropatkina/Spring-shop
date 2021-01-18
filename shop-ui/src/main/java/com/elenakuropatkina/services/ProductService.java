package com.elenakuropatkina.services;

import com.elenakuropatkina.controllers.ProductRepresent;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductRepresent> findAll();

    Optional<ProductRepresent> findById(Long id);

    void delete(Long id);

    void save(ProductRepresent product) throws IOException;
}
