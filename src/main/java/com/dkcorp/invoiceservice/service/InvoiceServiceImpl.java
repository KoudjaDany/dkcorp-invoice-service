package com.dkcorp.invoiceservice.service;

import com.dkcorp.invoiceservice.domain.Invoice;
import com.dkcorp.invoiceservice.dtos.InvoiceDto;
import com.dkcorp.invoiceservice.dtos.InvoiceResponseDto;
import com.dkcorp.invoiceservice.repository.InvoiceRepository;
import com.dkcorp.invoiceservice.service.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository InvoiceRepository;
    private final InvoiceMapper InvoiceMapper;

    @Override
    public InvoiceResponseDto save(InvoiceDto InvoiceDto) {
        Invoice Invoice = InvoiceMapper.toEntity(InvoiceDto);
        final Invoice savedInvoice = InvoiceRepository.save(Invoice);
        return InvoiceMapper.toResponseDto(savedInvoice);
    }

    @Override
    public InvoiceResponseDto update(InvoiceDto InvoiceDto) {
        Invoice Invoice = InvoiceMapper.toEntity(InvoiceDto);
        final Invoice savedInvoice = InvoiceRepository.save(Invoice);
        return InvoiceMapper.toResponseDto(savedInvoice);
    }

    @Override
    public InvoiceResponseDto readOne(Long InvoiceId) {
        return InvoiceRepository.findById(InvoiceId)
                .map(InvoiceMapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Unable to find the specified Invoice."));
    }

    @Override
    public void delete(Long InvoiceId) {
        InvoiceRepository.deleteById(InvoiceId);
    }

    @Override
    public List<InvoiceResponseDto> findAll() {
        return InvoiceRepository.findAll()
                .stream()
                .map(InvoiceMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
