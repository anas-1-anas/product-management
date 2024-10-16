package com.carrefour.productmanagement;


import com.carrefour.productmanagement.model.Product;
import com.carrefour.productmanagement.repository.ProductRepository;
import com.carrefour.productmanagement.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    public ProductServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetProductById() {
        Product product = new Product();
        product.setId(1055L);
        when(productRepository.findById(1055L)).thenReturn(Optional.of(product));

        Optional<Product> foundProduct = productService.getProductById(1055L);
        assertTrue(foundProduct.isPresent());
        assertEquals(1055L, foundProduct.get().getId());
    }
}
