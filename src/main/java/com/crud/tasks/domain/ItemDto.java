package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ItemDto {

        private Long id;

        private BigDecimal price;

        private int quantity;

        private BigDecimal value;

        private TaskDto task;
}
