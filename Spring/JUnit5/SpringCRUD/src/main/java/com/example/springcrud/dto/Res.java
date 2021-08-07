package com.example.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Res {
    private int result;
    private Body response;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body{
        private String resultCode="OK";
    }
}
