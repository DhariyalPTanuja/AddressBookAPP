package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/addressbookapp")
public class AddressBookController {
//get the data

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String> getAddressData(){
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }
//GetMapping is used to Fetch the data from DataBase using id
    @GetMapping("/get/{userId}")
    public ResponseEntity<String> getAddressData(@PathVariable("userId") int userId){
        return new ResponseEntity<String>("Get Call Success for id", HttpStatus.OK);
    }
  //PostMapping add new data in the database
  @PostMapping("/add")
  public ResponseEntity<String> addAddressData(@RequestBody String fName, String lName , String gender){
      return new ResponseEntity<String>("Add an Address detail :"  + "Name : " + fName + "  " +lName  +
              "gender : " + gender
              , HttpStatus.OK);
  }
    //PutMapping : To update the data
    @PutMapping("/update/{fName}")
    public ResponseEntity<String> updateAddressData(@RequestBody  String lName , String gender ,@PathVariable String fName ){
        return new ResponseEntity<String>("update data successfully ..."  + "Name : " + fName + "  " +lName  +
                "gender : " + gender ,HttpStatus.OK);
    }
    //DeleteMapping: to delete the data
    @DeleteMapping("/delete/{fName}")
    public ResponseEntity<String> deleteAddressData(@PathVariable String fName){
        return new ResponseEntity<>("delete the data successfully",HttpStatus.OK);

    }
}
