package com.indocyber.penjualan.service.abstraction;

import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.entity.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<ProductGridDTO> getListProduct(Integer page, String productName);

    ProductGridDTO getProductDetail(String productCode);
}
