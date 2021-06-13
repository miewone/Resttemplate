package com.example.server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req<T> {

    private Header header;
    private T innerBody;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header
    {
        private String responseCode;
    }
}
