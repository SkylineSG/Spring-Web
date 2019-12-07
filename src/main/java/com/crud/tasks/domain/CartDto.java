package com.crud.tasks.domain;

import com.crud.tasks.domain.Product;
import com.crud.tasks.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private long id;
    private User user;
    private List<Product> products;
}