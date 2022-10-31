package com.indocyber.penjualan.dto.transaction;

import com.indocyber.penjualan.entity.Product;
import com.indocyber.penjualan.entity.TransactionDetail;
import com.indocyber.penjualan.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class InsertTransaction {
    private String documentNumber;

    private String documentCode;

    private String username;

    private double total;

    private LocalDate transactionDate ;

    private String productCode;

    private Integer quantity;


}
