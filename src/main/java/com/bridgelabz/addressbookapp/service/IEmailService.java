package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.model.Email;
import org.springframework.http.ResponseEntity;



public interface IEmailService {
    public ResponseEntity<ResponseDto> sendEmail(Email emailModel) ;
}
