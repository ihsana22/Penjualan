package com.indocyber.penjualan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TransactionDetail")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class TransactionDetail {
    @Id
    @Column(name = "TransactionCode")
    private String transactionCode;

    @OneToMany(mappedBy = "transactionDetail")
    private List<TransactionHeader> transactionHeaderList;

    @Column(name = "SubTotal")
    private Double subTotal;

}
