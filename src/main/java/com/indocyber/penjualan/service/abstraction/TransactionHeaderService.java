package com.indocyber.penjualan.service.abstraction;

import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.dto.transaction.ReportGridDTO;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import com.indocyber.penjualan.entity.TransactionHeader;
import org.springframework.data.domain.Page;

import java.util.List;

public interface TransactionHeaderService {
    void insertTransaction(String productCode, String username, InsertTransaction dto);

    Page<TransactionGridDTO> getListCart(Integer page,String username);

    void insertTransactionDetail(String username,double total);

    List<ReportGridDTO> getListReport(String username);


}
