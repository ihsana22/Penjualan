package com.indocyber.penjualan.repository;

import com.indocyber.penjualan.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail,String> {
    @Query("""
            SELECT td
            FROM TransactionDetail td
            """)
    TransactionDetail findTd();
}
