package com.indocyber.penjualan.service.abstraction;

import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import org.springframework.data.domain.Page;

public interface TransactionHeaderService {
    void insertTransaction(String productCode, String username, InsertTransaction dto);

    Page<TransactionGridDTO> getListCart(Integer page,String username);

    void insertTransactionDetail(Double subTotal,String username);
}
