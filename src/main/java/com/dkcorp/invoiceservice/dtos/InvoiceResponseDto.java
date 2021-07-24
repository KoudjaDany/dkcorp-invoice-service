package com.dkcorp.invoiceservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceResponseDto {
    private Long id;
    private String name;
    private String email;
}
