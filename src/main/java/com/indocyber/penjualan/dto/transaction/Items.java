package com.indocyber.penjualan.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class Items {
    private String transactionNumber;
    private String transactionCode;
    private Double subTotal;
    private LocalDate transactionDate;
    private String username;
    private String productName;
    private Integer quantity;
    private List<String> ListProduct;
    private List<Integer> listQuantity;
 }
