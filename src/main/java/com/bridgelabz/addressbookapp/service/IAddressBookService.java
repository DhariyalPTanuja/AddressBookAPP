package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBookModel;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {
     String welcomeMsg();
     AddressBookModel addData(AddressBookDto addressBookDto);
     AddressBookModel getAddressBookData(int id);
     List<AddressBookModel> findAddressBookDataByState(String state);
     List<AddressBookModel> getAllAddressBookData();
     AddressBookModel updateAddressBookData(AddressBookDto addressBookDto, int id);
     void deleteData(int id);
     AddressBookModel getByToken(String token);
     AddressBookModel updateAddressBookDataByToken(int id, String token,AddressBookDto addressBookDto);


}
