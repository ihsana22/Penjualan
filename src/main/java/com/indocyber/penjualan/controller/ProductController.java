package com.indocyber.penjualan.controller;

import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.entity.Product;
import com.indocyber.penjualan.service.abstraction.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/index")
    public String index (@RequestParam(defaultValue = "1")Integer page,
                         @RequestParam(defaultValue = "")String productName,
                         Model model){
        var pageObject = service.getListProduct(page,productName);


        model.addAttribute("breadCrumbs","Product Index");
        model.addAttribute("grid",pageObject);
        model.addAttribute("totalPages",pageObject.getTotalPages());
        model.addAttribute("currentPage",page);
        return "product/product-index";
    }
    @GetMapping("/detail")
    public String detailProduct(@RequestParam(defaultValue = "") String productCode, Model model){
        var grid = service.getProductDetail(productCode);
        model.addAttribute("grid",grid);
        model.addAttribute("breadCrumbs","Detail Product");
        return "product/product-detail";
    }
    @GetMapping("/buyForm")
    public String buyForm(@RequestParam(defaultValue = "")String productCode, Model model){
        InsertTransaction insertTransaction = new InsertTransaction();
        model.addAttribute("product",service.getProductDetail(productCode));
        model.addAttribute("transaction",insertTransaction);
        model.addAttribute("productCode",productCode);
        return "transaction/transaction-form";
    }
}
