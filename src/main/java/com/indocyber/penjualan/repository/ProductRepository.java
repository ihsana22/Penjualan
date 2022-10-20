package com.indocyber.penjualan.repository;

import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product,String> {

    @Query("""
            SELECT new com.indocyber.penjualan.dto.product.ProductGridDTO
            (pro.productCode,pro.productName,pro.price,pro.currency,pro.discount,pro.dimension,pro.unit,pro.stock,pro.imagePath)
            FROM Product pro
            WHERE  pro.productName LIKE %:name%
            """)
    Page<ProductGridDTO> getAllProduct(@Param("name") String productName, Pageable pageable);



}
