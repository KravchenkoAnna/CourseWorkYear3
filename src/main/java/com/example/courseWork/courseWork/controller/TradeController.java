package com.example.courseWork.courseWork.controller;

import com.example.courseWork.courseWork.dto.trade.AgregatedTrade;
import com.example.courseWork.courseWork.dto.trade.TradeRequest;
import com.example.courseWork.courseWork.dto.trade.TradeResponse;
import com.example.courseWork.courseWork.service.TradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/trade")
public class TradeController {

    private final TradeService tradeService;

    @GetMapping
    public List<AgregatedTrade> findAll(){
        return tradeService.findAll();
    }

    @GetMapping("/{id}")
    public TradeResponse findById(@PathVariable Long id){
        return tradeService.findById(id);
    }

    @PutMapping("/{id}")
    public TradeResponse update(@PathVariable Long id, @RequestBody TradeRequest tradeRequest){
        return tradeService.update(id, tradeRequest);
    }

    @PostMapping
    public TradeResponse create(@RequestBody TradeRequest tradeRequest){
        return tradeService.create(tradeRequest);
    }

    @DeleteMapping ("/{id}")
    public void deletePollution(@PathVariable Long id){
        tradeService.delete(id);
    }

}
