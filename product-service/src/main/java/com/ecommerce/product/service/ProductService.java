package com.ecommerce.product.service;

import com.ecommerce.product.domain.Product;
import com.ecommerce.product.dto.ProductRequestDTO;
import com.ecommerce.product.dto.ProductResponseDTO;
import com.ecommerce.product.exception.ProductNotFoundException;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ========================
    // CREATE
    // ========================
    @Transactional
    public ProductResponseDTO create(ProductRequestDTO request) {

        if (productRepository.existsByNameIgnoreCase(request.getName())) {
            throw new IllegalArgumentException("Product already exists with this name");
        }

        Product product = ProductMapper.toEntity(request);
        Product savedProduct = productRepository.save(product);

        return ProductMapper.toResponse(savedProduct);
    }

    // ========================
    // READ
    // ========================
    @Transactional(readOnly = true)
    public ProductResponseDTO findById(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return ProductMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponseDTO> findAllActive() {
        return productRepository.findByActiveTrue()
                .stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());
    }

    // ========================
    // UPDATE
    // ========================
    @Transactional
    public ProductResponseDTO update(UUID id, ProductRequestDTO request) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        if (request.getName() != null) {
            product.updatePrice(product.getPrice()); // mantém preço se não vier
        }

        if (request.getPrice() != null) {
            product.updatePrice(request.getPrice());
        }

        if (request.getActive() != null) {
            if (request.getActive()) {
                product.activate();
            } else {
                product.deactivate();
            }
        }

        return ProductMapper.toResponse(product);
    }

    // ========================
    // DELETE (logical)
    // ========================
    @Transactional
    public void deactivate(UUID id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        product.deactivate();
    }
}
