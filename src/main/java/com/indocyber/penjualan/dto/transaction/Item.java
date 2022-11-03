package com.indocyber.penjualan.dto.transaction;

import lombok.*;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private String productName;
    private Integer quantity;
}
