package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbookapp")
public class AddressBookController {
//get the data
@Autowired
    IAddressBookService serviceAddressBook;
    List<AddressBookModel> addressBookList = new ArrayList<>();

    @GetMapping("/welcome")
    public void aboutAddressBook(){
        serviceAddressBook.welcomeMsg();
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> fetchData(){
        addressBookList = serviceAddressBook.getAllAddressBookData();
        ResponseDto responseDto = new ResponseDto("fetch address book data successfully",addressBookList);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
    //get data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> fetchDataById(@PathVariable int id){
        AddressBookModel addressBookModel = serviceAddressBook.getAddressBookData(id);
        ResponseDto responseDTO = new ResponseDto("fetch record by id",addressBookModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> insertAddressBookData(@RequestBody AddressBookDto addressBookDto){
        AddressBookModel addressBookModel = serviceAddressBook.addData(addressBookDto);
        ResponseDto responseDTO = new ResponseDto("New data record in addressbook",addressBookModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateData(@RequestBody AddressBookDto addressBookDto,@PathVariable int id){
        AddressBookModel addressBookModel = serviceAddressBook.updateAddressBookData(addressBookDto,id);
        ResponseDto responseDTO = new ResponseDto("existing  data updated successfully",addressBookModel);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressData(@PathVariable int id){
        serviceAddressBook.deleteData(id);
        return new ResponseEntity<>("delete the data successfully",HttpStatus.OK);

    }
}
