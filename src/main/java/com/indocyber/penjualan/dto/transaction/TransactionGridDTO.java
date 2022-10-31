package com.indocyber.penjualan.dto.transaction;

import com.indocyber.penjualan.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class TransactionGridDTO {
    private String productCode;
    private String imagePath;
    private Integer quantity;
    private String productName;
    private Double total;
    private String unit;
    private Double price;
}
