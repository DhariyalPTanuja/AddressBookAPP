package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
    @Autowired
    AddressBookRepository addressBookRepo;

    @Override
    public String welcomeMsg() {
        return "Welcome To the Address Book System, " +
                "we are using Spring Boot to create AddressBookService App";
    }

    @Override
    public AddressBookModel addData(AddressBookDto addressBookDto) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        return addressBookRepo.save(addressBookModel);
    }

    @Override
    public AddressBookModel getAddressBookData(int id) {
        AddressBookModel addressBookModel = addressBookRepo.findById(id).get();
        return addressBookModel;
    }

    @Override
    public List<AddressBookModel> getAllAddressBookData() {
        List<AddressBookModel> addressBookList = addressBookRepo.findAll();
        return addressBookList;
    }
    @Override
    public AddressBookModel updateAddressBookData(AddressBookDto addressBookDto, int id) {
//        Optional<AddressBookModel> checkId = addressBookRepo.findById(id);
        // EmployeePayrollDataModel empObj = new EmployeePayrollDataModel(id,empDto);
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        addressBookRepo.save(addressBookModel);
        return addressBookModel;

    }
//    @Override
//    public AddressBookModel updateAddressBookData(AddressBookDto addressBookDto, int id) {
//    Optional<AddressBookModel> checkId = addressBookRepo.findById(id);
//    if(checkId.isPresent()){
//        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
//        addressBookRepo.save(addressBookModel);
//        return addressBookModel;
//    }
//    else
//        return null;
//
//    }

    @Override
    public void deleteData(int id) {
        Optional<AddressBookModel> checkId = addressBookRepo.findById(id);
        if(checkId.isPresent())
            addressBookRepo.deleteById(id);
       else
           log.info("id not found");
    }
}
