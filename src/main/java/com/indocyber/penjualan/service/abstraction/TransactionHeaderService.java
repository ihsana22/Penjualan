package com.indocyber.penjualan.service.abstraction;

import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.dto.transaction.ListProductReportDTO;
import com.indocyber.penjualan.dto.transaction.ReportGridDTO;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionHeaderService {
    void insertTransaction(String productCode, String username, InsertTransaction dto);

    Page<TransactionGridDTO> getListCart(Integer page,String username);

    void insertTransactionDetail(String username,double total);

    List<ReportGridDTO> getListReport(String username);

    List<ListProductReportDTO> getListProductReport(String username);
}
