package com.indocyber.penjualan.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportGridDTO {
    private String transactionNumber;
    private String transactionCode;
    private Double subTotal;
    private LocalDate transactionDate;
    private String username;
    private String productName;
    private Integer quantity;
    public List<Item> listItem (){
        List<Item> items = null;
        if (items == null){
            items = new ArrayList<>();
        }
        items.add(new Item(this.productName,this.quantity));
        return items;
    }
}
