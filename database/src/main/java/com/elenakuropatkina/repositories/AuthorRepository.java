package com.elenakuropatkina.repositories;


import com.elenakuropatkina.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Author, Long> {
}
