package com.example.courseWork.courseWork.service;

import com.example.courseWork.courseWork.dto.supplier.SupplierRequest;
import com.example.courseWork.courseWork.dto.supplier.SupplierResponse;
import com.example.courseWork.courseWork.exception.SupplierNotFoundException;
import com.example.courseWork.courseWork.mapper.SupplierMapper;
import com.example.courseWork.courseWork.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    @Transactional
    public SupplierResponse create(SupplierRequest supplierRequest){

        var supplierToCreate = supplierMapper.fromSupplierRequest(supplierRequest);

        var createdSupplier = supplierRepository.save(supplierToCreate);
        return supplierMapper.toSupplierResponse(createdSupplier);
    }
    @Transactional
    public SupplierResponse update(Long id, SupplierRequest supplierRequest){

        var currentSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("id = " + id));

        currentSupplier.setName(supplierRequest.name());
        currentSupplier.setAddress(supplierRequest.address());
        currentSupplier.setPhoneNumber(supplierRequest.phoneNumber());

        return supplierMapper.toSupplierResponse(currentSupplier);
    }

    @Transactional
    public void delete(Long id){
        var currentSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("id = " + id));
        supplierRepository.delete(currentSupplier);
    }

    public SupplierResponse getById(Long id){
        var retrievedSupplier = supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException("id = " + id));
        return supplierMapper.toSupplierResponse(retrievedSupplier);
    }

    public List<SupplierResponse> getAll(){
        return supplierRepository.findAllBy(SupplierResponse.class);
    }
}
