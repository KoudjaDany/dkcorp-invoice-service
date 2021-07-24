package com.dkcorp.invoiceservice.restapi;

import com.dkcorp.invoiceservice.dtos.InvoiceDto;
import com.dkcorp.invoiceservice.dtos.InvoiceResponseDto;
import com.dkcorp.invoiceservice.service.InvoiceService;
import org.springframework.core.MethodParameter;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/Invoices")
public class InvoiceResource {

    private final InvoiceService InvoiceService;

    public InvoiceResource(InvoiceService InvoiceService) {
        this.InvoiceService = InvoiceService;
    }


    @PostMapping("/create")
    public ResponseEntity<InvoiceResponseDto> create(@RequestBody @Valid InvoiceDto InvoiceDto, BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
        if(InvoiceDto.getId() != null){
            throw new IllegalArgumentException("The Id of a new invoice must be null.");
        }
        if (bindingResult.hasErrors()){
            throw new MethodArgumentNotValidException(new MethodParameter(InvoiceResource.class.getMethod("create", InvoiceDto.class, BindingResult.class), 0), bindingResult);
        }
        return ResponseEntity.ok(InvoiceService.save(InvoiceDto));
    }

    @PutMapping("/update")
    public ResponseEntity<InvoiceResponseDto> update(@RequestBody @Valid InvoiceDto InvoiceDto, BindingResult bindingResult) throws NoSuchMethodException, MethodArgumentNotValidException {
        if(InvoiceDto.getId() == null){
            throw new IllegalArgumentException("The Id must not be null.");
        }
        if (bindingResult.hasErrors()){
            throw new MethodArgumentNotValidException(new MethodParameter(InvoiceResource.class.getMethod("update", InvoiceDto.class, BindingResult.class), 0), bindingResult);
        }
        return ResponseEntity.ok(InvoiceService.update(InvoiceDto));
    }

    @GetMapping("/detail/{InvoiceId}")
    public ResponseEntity<InvoiceResponseDto> details(@PathVariable @NotNull(message = "Invoice id is required") Long InvoiceId){
        return ResponseEntity.ok(InvoiceService.readOne(InvoiceId));
    }

    @DeleteMapping("/delete/{InvoiceId}")
    public void delete(@PathVariable @NotNull(message = "Invoice id is required") Long InvoiceId){
        InvoiceService.delete(InvoiceId);
    }

    @GetMapping("")
    public ResponseEntity<List<InvoiceResponseDto>> findAll(){
        return ResponseEntity.ok(InvoiceService.findAll());
    }
}
