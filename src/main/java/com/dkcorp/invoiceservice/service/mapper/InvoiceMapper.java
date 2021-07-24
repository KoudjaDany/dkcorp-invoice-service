package com.dkcorp.invoiceservice.service.mapper;

import com.dkcorp.invoiceservice.domain.Invoice;
import com.dkcorp.invoiceservice.dtos.InvoiceDto;
import com.dkcorp.invoiceservice.dtos.InvoiceResponseDto;
import com.dkcorp.invoiceservice.repository.InvoiceRepository;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = InvoiceMapper.InvoiceMapperFactory.class)
public abstract class InvoiceMapper {

    @Autowired
    public InvoiceRepository InvoiceRepository;

    public abstract Invoice toEntity(InvoiceDto InvoiceDto);

    public abstract InvoiceResponseDto toResponseDto(Invoice Invoice);

    @Component
    class InvoiceMapperFactory{
        @ObjectFactory
        Invoice fromDto(InvoiceDto InvoiceDto){
            if (InvoiceDto.getId() != null){
              return  InvoiceRepository.findById(InvoiceDto.getId())
                      .orElse(new Invoice());
            }
            return new Invoice();
        }
    }
}
