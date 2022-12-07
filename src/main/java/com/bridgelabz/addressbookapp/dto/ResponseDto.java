package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

public @Data class ResponseDto {
    private String msg;
    private Object data;

    public ResponseDto(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }
}
