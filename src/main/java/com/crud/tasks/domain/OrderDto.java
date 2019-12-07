package com.crud.tasks.domain;

import com.crud.tasks.domain.Cart;
import com.crud.tasks.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long id;
    private String title;
    private double totalCost;
    private UserDto userDto;
    private CartDto cartDto;
}