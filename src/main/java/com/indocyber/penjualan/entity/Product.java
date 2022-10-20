package com.indocyber.penjualan.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Product")
@Setter @Getter
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "ProductCode")
    private String productCode;

    @Column(name = "ProductName")
    private String productName;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Currency")
    private String currency;

    @Column(name = "Discount")
    private Double discount;

    @Column(name = "Dimension")
    private String dimension;

    @Column(name = "Unit")
    private String unit;

    @Column(name = "Stock")
    private Integer stock;

    @Column(name = "ImagePath")
    private String imagePath;

    @OneToMany(mappedBy = "product")
    private List<TransactionHeader> transactionHeaderList;
}
