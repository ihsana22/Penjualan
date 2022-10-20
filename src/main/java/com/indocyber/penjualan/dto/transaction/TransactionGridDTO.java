package com.indocyber.penjualan.dto.transaction;

import com.indocyber.penjualan.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class TransactionGridDTO {
    private String productCode;
    private String imagePath;
    private Integer quantity;
    private String productName;
    private Double total;
    private String unit;

    public TransactionGridDTO(String productCode, String imagePath, Integer quantity, String productName, Double total,String unit) {
        this.productCode = productCode;
        this.imagePath = imagePath;
        this.quantity = quantity;
        this.productName = productName;
        this.total = total;
        this.unit =unit;
    }
//    public Double subTotal(){
//        Double totalConfirm = this.total*this.quantity;
//
//        return totalConfirm;
//    }
}
