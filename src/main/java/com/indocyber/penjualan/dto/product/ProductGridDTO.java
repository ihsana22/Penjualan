package com.indocyber.penjualan.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.sound.midi.MidiFileFormat;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductGridDTO {

    private String productCode;

    private String productName;

    private Double price;

    private String currency;

    private Double discount;

    private String dimension;

    private String unit;

    private Integer stock;

    private String imagePath;

    public Double priceDiscount(){
        Double totalDiskon = (this.price*this.discount)/100;
        Double hargaSetelahDiskon = this.price-totalDiskon;
        return hargaSetelahDiskon;
    }
}
