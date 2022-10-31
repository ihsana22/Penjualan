package com.indocyber.penjualan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDetailId implements Serializable {
    @Column(name = "TransactionCode")
    private String transactionCode;
    @Column(name = "TransactionNumber")
    private String transactionNumber;

    @Override
    public int hashCode() {
        return Objects.hash(transactionCode,transactionNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TransactionDetailId that = (TransactionDetailId) obj;
        return Objects.equals(transactionCode, that.transactionCode)
                && Objects.equals(transactionNumber, that.transactionNumber);
    }
}
