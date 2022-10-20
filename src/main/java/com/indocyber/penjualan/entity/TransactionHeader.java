package com.indocyber.penjualan.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Table(name = "TransactionHeader")
public class TransactionHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionNumber")
    private Integer transactionNumber;

    @Column(name = "DocumentCode")
    private String documentCode;

    @Column(name = "Total")
    private double total;

    @Column(name = "TransactionDate")
    private LocalDate transactionDate;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "Username",updatable = false,insertable = false)
    private Users users;

    @Column(name = "Username")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TransactionCode")
    private TransactionDetail transactionDetail;
    @ManyToOne
    @JoinColumn(name = "ProductCode",insertable = false,updatable = false)
    private Product product;

    @Column(name = "ProductCode")
    private String productCode;

}
