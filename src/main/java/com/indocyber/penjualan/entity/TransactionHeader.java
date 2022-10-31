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
//@IdClass(TransactionHeaderId.class)
@Table(name = "TransactionHeader")
public class TransactionHeader {
    @EmbeddedId
    private TransactionHeaderId transactionHeaderId;

    @Column(name = "Total")
    private double total;

    @Column(name = "Quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "Username",updatable = false,insertable = false)
    private Users users;

    @Column(name = "Username")
    private String username;

    @ManyToOne
    private TransactionDetail transactionDetail;

    @ManyToOne
    @JoinColumn(name = "ProductCode",insertable = false,updatable = false)
    private Product product;

    @Column(name = "ProductCode")
    private String productCode;

}
