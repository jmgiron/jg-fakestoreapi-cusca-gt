
package com.jg.fakestoreapi.controller;

import com.jg.fakestoreapi.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductProxyController {

    private final WebClient webClient;

    public ProductProxyController() {
        this.webClient = WebClient.builder().baseUrl("https://fakestoreapi.com").build();
    }

    @GetMapping
    public List<ProductDto> list() {
        ProductDto[] arr = webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductDto[].class)
                .block();
        if (arr == null) return List.of();
        return Arrays.asList(arr);
    }

    @GetMapping("/{id}")
    public ProductDto get(@PathVariable Integer id) {
        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(ProductDto.class)
                .block();
    }
}
