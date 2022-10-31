package com.indocyber.penjualan.repository;


import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import com.indocyber.penjualan.entity.TransactionHeader;
import com.indocyber.penjualan.entity.TransactionHeaderId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface TransactionHeaderRepository extends JpaRepository<TransactionHeader, TransactionHeaderId> {
    @Query("""
            SELECT tr
            FROM TransactionHeader tr
            JOIN tr.product pr
            WHERE pr.productCode = :code
            AND tr.transactionDetail = null
            AND tr.username = :username
            """)
    TransactionHeader getByProduct(@Param("code") String productCode,@Param("username") String username);

    @Query("""
            SELECT new com.indocyber.penjualan.dto.transaction.TransactionGridDTO
            (pr.productCode,pr.imagePath,tr.quantity,pr.productName,tr.total,pr.unit,pr.price)
            FROM TransactionHeader tr
            JOIN tr.product pr
            JOIN tr.users us
            WHERE tr.transactionDetail = null
            AND us.username = :user   
            """)
    Page<TransactionGridDTO> getAllCart(Pageable pageable,@Param("user") String username);

    @Query("""
            SELECT MAX(th.transactionHeaderId.documentNumber)
            FROM TransactionHeader th
            """)
    String getHighestNumber();

    @Query("""
            SELECT th
            FROM TransactionHeader th
            WHERE th.username = :user
            AND th.transactionDetail = null
            """)
    List<TransactionHeader> getCart(@Param("user") String username);
}
