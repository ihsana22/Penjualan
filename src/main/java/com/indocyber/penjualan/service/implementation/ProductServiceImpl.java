package com.indocyber.penjualan.service.implementation;

import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.entity.Product;
import com.indocyber.penjualan.repository.ProductRepository;
import com.indocyber.penjualan.service.abstraction.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    private final int rowInPage = 5;
    @Override
    public Page<ProductGridDTO> getListProduct(Integer page, String productName) {
        Pageable pageable = PageRequest.of(page-1,rowInPage, Sort.by("id"));
        Page<ProductGridDTO> listProduct= productRepository.getAllProduct(productName,pageable);


        return listProduct;
    }

    @Override
    public ProductGridDTO getProductDetail(String productCode) {
        Optional<Product> optional = productRepository.findById(productCode);
        Product product = optional.get();
        ProductGridDTO productGridDTO = new ProductGridDTO(product.getProductCode(),product.getProductName(),product.getPrice(),product.getCurrency(),product.getDiscount(),product.getDimension(),product.getUnit(),product.getStock(),product.getImagePath());
        return productGridDTO;
    }
}
