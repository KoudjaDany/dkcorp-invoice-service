package com.dkcorp.invoiceservice.service;


import com.dkcorp.invoiceservice.dtos.InvoiceDto;
import com.dkcorp.invoiceservice.dtos.InvoiceResponseDto;

import java.util.List;

public interface InvoiceService {

    InvoiceResponseDto save(InvoiceDto InvoiceDto);
    InvoiceResponseDto update(InvoiceDto InvoiceDto);
    InvoiceResponseDto readOne(Long InvoiceId);
    void delete(Long InvoiceId);
    List<InvoiceResponseDto> findAll();
}
