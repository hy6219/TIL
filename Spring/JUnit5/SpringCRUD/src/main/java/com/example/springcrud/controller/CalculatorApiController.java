package com.example.springcrud.controller;

import com.example.springcrud.component.Calculator;
import com.example.springcrud.component.ICalculator;
import com.example.springcrud.dto.Req;
import com.example.springcrud.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x , @RequestParam int y){
        return calculator.sum(x, y);
    }

    @PostMapping("/minus")
    public Res minus(@RequestBody Req req){
        int res= calculator.minus(req.getX(),req.getY());
        Res response = new Res();

        response.setResult(res);
        response.setResponse(new Res.Body());
        return response;
    }
}
