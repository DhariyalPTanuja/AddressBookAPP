package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

public @Data class ResponseDto {
    private String msg;
    private Object data;

    private String token;

    public ResponseDto(String msg, Object data, String token) {
        this.msg = msg;
        this.data = data;
        this.token = token;
    }


}
