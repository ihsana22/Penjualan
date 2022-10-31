package com.indocyber.penjualan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TransactionDetail")
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(TransactionDetailId.class)
@Setter @Getter
public class TransactionDetail {

    @EmbeddedId
    private TransactionDetailId transactionDetailId;

    @OneToMany(mappedBy = "transactionDetail")
    private List<TransactionHeader> transactionHeaderList;

    @Column(name = "TransactionDate")
    private LocalDate transactionDate;

    @Column(name = "SubTotal")
    private Double subTotal;

}
