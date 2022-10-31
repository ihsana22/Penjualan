package com.indocyber.penjualan.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TransactionHeaderId implements Serializable {

    @Column(name = "DocumentNumber")
    private String documentNumber;

    @Column(name = "DocumentCode")
    private String documentCode;

    @Override
    public int hashCode() {
        return Objects.hash(documentCode,documentNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TransactionHeaderId that = (TransactionHeaderId) obj;
        return Objects.equals(documentCode, that.documentCode)
                && Objects.equals(documentNumber, that.documentNumber);
    }
}
