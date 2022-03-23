package com.ioc.domain.entity;

import lombok.Builder;

public class Product {
    private String name;
    private int price;

    @Builder
    private Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Product of(String name, int price) {
        return Product.builder()
                .name(name)
                .price(price)
                .build();
    }
}
