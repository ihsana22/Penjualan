package com.indocyber.penjualan.controller;

import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import com.indocyber.penjualan.service.abstraction.TransactionHeaderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionHeaderService service;

    @PostMapping("/buy")
    public String addToCart(@ModelAttribute("transaction") InsertTransaction dto,
                            @RequestParam(defaultValue = "")String productCode,
                            Authentication authentication,Model model){
        String username =authentication.getName();
        service.insertTransaction(productCode,username,dto);
        return "redirect:/product/index";
    }
    @GetMapping("/cart")
    public String myCart(@RequestParam(defaultValue = "1")Integer page,
                         Authentication authentication,
                         Model model){
        String username = authentication.getName();
        var dto =service.getListCart(page,username);
        model.addAttribute("dto",dto);
        model.addAttribute("currentPage",page);
        model.addAttribute("totalPages",dto.getTotalPages());
        List<TransactionGridDTO> list = dto.stream().toList();
        double total = 0;
        for (TransactionGridDTO tr : list){
            total=total+tr.getTotal();
        model.addAttribute("breadCrumbs","Sub Total : Rp. "+total);
        }
        return "transaction/transaction-cart";
    }

    @GetMapping("/confirm")
    public String confirm(@RequestParam(defaultValue = "")Double subTotal,Model model,Authentication authentication){
        String username = authentication.getName();
        model.addAttribute("subTotal",subTotal);
        service.insertTransactionDetail(subTotal,username);
        return "redirect:/transaction/cart";
    }
    @GetMapping("/report")
    public String report(Authentication authentication,Model model){

     return "transaction/transaction-report";
    }
}
