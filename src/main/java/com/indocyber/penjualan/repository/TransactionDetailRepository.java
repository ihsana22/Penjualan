package com.indocyber.penjualan.repository;

import com.indocyber.penjualan.dto.transaction.ReportGridDTO;
import com.indocyber.penjualan.entity.TransactionDetail;
import com.indocyber.penjualan.entity.TransactionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail,String> {


    @Query("""
            SELECT DISTINCT new com.indocyber.penjualan.dto.transaction.ReportGridDTO
            (td.transactionDetailId.transactionNumber,td.transactionDetailId.transactionCode,td.subTotal,td.transactionDate,us.username,pr.productName,th.quantity)
            FROM TransactionDetail td
            JOIN td.transactionHeaderList th
            JOIN th.product pr
            JOIN th.users us
            WHERE us.username = :name
            """)
    List<ReportGridDTO> findReport(@Param("name") String username);



    @Query("""
            SELECT MAX(td.transactionDetailId.transactionNumber)
            FROM TransactionDetail td
            """)
    String getHighestNumber();

}
