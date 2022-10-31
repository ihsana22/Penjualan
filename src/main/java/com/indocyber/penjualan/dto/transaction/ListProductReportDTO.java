package com.indocyber.penjualan.dto.transaction;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListProductReportDTO {
    private String productName;
    private Integer quantity;
}
