package com.example.courseWork.courseWork.controller;

import com.example.courseWork.courseWork.dto.detal.DetalRequest;
import com.example.courseWork.courseWork.dto.detal.DetalResponse;
import com.example.courseWork.courseWork.service.DetalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/detals")
public class DetalController {
    private final DetalService detalService;

    @GetMapping
    public ResponseEntity<List<DetalResponse>> findAll(){
        List<DetalResponse> list = detalService.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public DetalResponse findById(@PathVariable Long id){
        return detalService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DetalResponse create(@RequestBody DetalRequest detalRequest){
        return detalService.create(detalRequest);
    }

    @PutMapping("/{id}")
    public DetalResponse update(@PathVariable("id") Long id, @RequestBody DetalRequest detalRequest){
        return detalService.update(id, detalRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        detalService.delete(id);
    }



}
