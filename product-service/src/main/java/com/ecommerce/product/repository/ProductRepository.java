package com.ecommerce.product.repository;

import com.ecommerce.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Buscar apenas produtos ativos
    List<Product> findByActiveTrue();

    // Verifica se existe produto com o mesmo nome (exemplo de regra de negócio)
    boolean existsByNameIgnoreCase(String name);
}
