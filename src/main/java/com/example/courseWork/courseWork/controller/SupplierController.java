package com.example.courseWork.courseWork.controller;

import com.example.courseWork.courseWork.dto.supplier.SupplierRequest;
import com.example.courseWork.courseWork.dto.supplier.SupplierResponse;
import com.example.courseWork.courseWork.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/suppliers")
public class SupplierController {
    private final SupplierService supplierService;
    @GetMapping
    public List<SupplierResponse> findAll(){
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public SupplierResponse findById(@PathVariable Long id){
        return supplierService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierResponse create(@RequestBody SupplierRequest supplierRequest){
        return supplierService.create(supplierRequest);
    }

    @PutMapping("/{id}")
    public SupplierResponse update(@PathVariable("id") Long id, @RequestBody SupplierRequest supplierRequest){
        return supplierService.update(id, supplierRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        supplierService.delete(id);
    }
}
