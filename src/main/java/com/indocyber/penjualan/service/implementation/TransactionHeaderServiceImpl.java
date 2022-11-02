package com.indocyber.penjualan.service.implementation;

import com.indocyber.penjualan.dto.product.ProductGridDTO;
import com.indocyber.penjualan.dto.transaction.InsertTransaction;
import com.indocyber.penjualan.dto.transaction.ReportGridDTO;
import com.indocyber.penjualan.dto.transaction.TransactionGridDTO;
import com.indocyber.penjualan.entity.*;
import com.indocyber.penjualan.repository.ProductRepository;
import com.indocyber.penjualan.repository.TransactionDetailRepository;
import com.indocyber.penjualan.repository.TransactionHeaderRepository;
import com.indocyber.penjualan.service.abstraction.TransactionHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionHeaderServiceImpl implements TransactionHeaderService {
    @Autowired
    private TransactionHeaderRepository transactionHeaderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    public String getDocumentNumber() {
        String lastNumber = transactionHeaderRepository.getHighestNumber();
        String docNumber = "";

        if (lastNumber == null){
            docNumber = "001";
        } else {
            int number = Integer.parseInt(lastNumber) + 1;

            if (number <= 9){
                docNumber = "00"+number;
            }
            else if(number <= 99){
                docNumber = "0"+number;
            } else {
                docNumber = Integer.toString(number);
            }
        }
        return docNumber;
    }
    public String getTransactionNumber() {
        String lastNumber = transactionDetailRepository.getHighestNumber();
        String docNumber = "";

        if (lastNumber == null){
            docNumber = "001";
        } else {
            int number = Integer.parseInt(lastNumber) + 1;

            if (number <= 9){
                docNumber = "00"+number;
            }
            else if(number <= 99){
                docNumber = "0"+number;
            } else {
                docNumber = Integer.toString(number);
            }
        }
        return docNumber;
    }


    private final Integer rowInPage = 10;

    @Override
    public void insertTransaction(String productCode, String username, InsertTransaction dto) {
        Product product = productRepository.findById(productCode).get();
        ProductGridDTO productGridDTO = new ProductGridDTO(product.getProductCode(),product.getProductName(),product.getPrice(),product.getCurrency(),product.getDiscount(),product.getDimension(),product.getUnit(),product.getStock(),product.getImagePath());
        TransactionHeader transactionHeader = transactionHeaderRepository.getByProduct(productCode,username);
        dto.setDocumentCode("TRX");
        dto.setDocumentNumber(getDocumentNumber());
        TransactionHeaderId transactionHeaderId=new TransactionHeaderId(dto.getDocumentNumber(),dto.getDocumentCode());
        if (transactionHeader == null) {
            TransactionHeader entity = new TransactionHeader();
            entity.setTransactionDetail(null);
            entity.setTransactionHeaderId(transactionHeaderId);
            entity.setUsername(username);
            entity.setProductCode(productCode);
            entity.setQuantity(dto.getQuantity());
            entity.setTotal(dto.getQuantity()*productGridDTO.getPrice());
            transactionHeaderRepository.save(entity);
        } else if (transactionHeader.getTransactionDetail() == null) {
            transactionHeader.setQuantity(transactionHeader.getQuantity()+ dto.getQuantity());
            transactionHeader.setTotal((transactionHeader.getTotal()* dto.getQuantity())+transactionHeader.getTotal());
            transactionHeaderRepository.save(transactionHeader);
        }
    }

    @Override
    public Page<TransactionGridDTO> getListCart(Integer page,String  username) {
        Pageable pageable = PageRequest.of(page-1,rowInPage, Sort.by("id"));
        var pageObject = transactionHeaderRepository.getAllCart(pageable,username);
        return pageObject;
    }

    @Override
    public void insertTransactionDetail(String username,double total) {
        TransactionDetail transactionDetail = new TransactionDetail();
        List<TransactionHeader> transactionHeader = transactionHeaderRepository.getCart(username);
        transactionDetail.setSubTotal(total);
        transactionDetail.setTransactionDate(LocalDate.now());
        TransactionDetailId transactionDetailId = new TransactionDetailId();
        transactionDetailId.setTransactionCode("TRX");
        transactionDetailId.setTransactionNumber(getTransactionNumber());
        transactionDetail.setTransactionDetailId(transactionDetailId);
         for (TransactionHeader tr : transactionHeader){
             transactionDetailRepository.save(transactionDetail);
             tr.setTransactionDetail(transactionDetail);
             transactionHeaderRepository.save(tr);
        }
    }

    @Override
    public List<ReportGridDTO> getListReport(String username) {
        List<ReportGridDTO> listReport=transactionDetailRepository.findReport(username);
        return listReport;
    }


}
