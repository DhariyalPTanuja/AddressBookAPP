package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import com.bridgelabz.addressbookapp.util.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//mark class as controller
@RestController
@RequestMapping("/addressbookapp")
public class AddressBookController {
//autowire te service class
@Autowired
    IAddressBookService serviceAddressBook;
//autowire the TokenUtil class
    @Autowired
    TokenUtil tokenUtil;
    List<AddressBookModel> addressBookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String aboutAddressBook(){
        return serviceAddressBook.welcomeMsg();
    }
    //Creating a get mapping that retrieves all the data from the database
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> fetchData(){
        addressBookList = serviceAddressBook.getAllAddressBookData();
        ResponseDto responseDto = new ResponseDto("fetch address book data successfully",addressBookList,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
     //Creating a get mapping that retrieves the data of specific id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDto> fetchDataById(@PathVariable int id){
        AddressBookModel addressBookModel = serviceAddressBook.getAddressBookData(id);
        ResponseDto responseDTO = new ResponseDto("fetch record by id",addressBookModel,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //Creating a get mapping that retrieves the data of specific state
    @GetMapping("/getbystate/{state}")
    public ResponseEntity<ResponseDto> fetchDataByState(@PathVariable("state") String state){
        List<AddressBookModel> stateList = null;
        stateList = serviceAddressBook.findAddressBookDataByState(state);
        ResponseDto responseDto = new ResponseDto("fetch address book data by state  successfully",stateList,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }
    //Creating a post mapping that post the data in the database
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> insertAddressBookData(@Valid @RequestBody AddressBookDto addressBookDto){
        AddressBookModel addressBookModel = serviceAddressBook.addData(addressBookDto);
        ResponseDto responseDTO = new ResponseDto("New data record in addressbook",addressBookModel,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }

    //Creating a put mapping that updates the record
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDto> updateData(@Valid @RequestBody AddressBookDto addressBookDto,@PathVariable int id) throws AddressBookException {
        AddressBookModel addressBookModel = serviceAddressBook.updateAddressBookData(addressBookDto,id);
        ResponseDto responseDTO = new ResponseDto("existing  data updated successfully",addressBookModel,null);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }

    //Creating a delete mapping that deletes a specified data
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressData(@PathVariable int id){
        serviceAddressBook.deleteData(id);
        return new ResponseEntity<>("delete the data successfully",HttpStatus.OK);

    }


    //Creating a get mapping that retrieves the data of specific token

    @GetMapping("/gettoken/{token}")
    public ResponseEntity<ResponseDto> fetchDataByToken(@PathVariable String token){
        AddressBookModel addressBookModel = serviceAddressBook.getByToken(token);
        ResponseDto responseDTO = new ResponseDto("fetch record by id",addressBookModel,token);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //Creating a post mapping with token that post the data in the database
    @PostMapping("/createwithtoken")
    public ResponseEntity<ResponseDto> insertAddressBookDataWithToken(@Valid @RequestBody AddressBookDto addressBookDto){
        AddressBookModel addressBookModel = serviceAddressBook.addData(addressBookDto);
        String tokenUtilToken = tokenUtil.createToken(addressBookModel.getId());
        ResponseDto responseDTO = new ResponseDto("New data record in addressbook",addressBookModel,tokenUtilToken );
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
    //Creating a put mapping that updates the record with token
    @PutMapping("/updatetoken/{id}")
    public ResponseEntity<ResponseDto> updateDataByToken(@Valid @PathVariable int id,@RequestParam String token, @RequestBody AddressBookDto addressBookDto) throws AddressBookException {
        AddressBookModel addressBookModel = serviceAddressBook.updateAddressBookData(addressBookDto,id);
        ResponseDto responseDTO = new ResponseDto("existing  data updated successfully",addressBookModel,token);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDTO, HttpStatus.OK);
        return response;
    }
}
