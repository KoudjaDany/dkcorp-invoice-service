package com.dkcorp.invoiceservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;

    @NotNull(message = "The Invoice name is required")
    private String name;

    @Email(message = "The email is invalid")
    private String email;
}
