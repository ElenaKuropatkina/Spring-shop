package com.elenakuropatkina.repositories;


import com.elenakuropatkina.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}