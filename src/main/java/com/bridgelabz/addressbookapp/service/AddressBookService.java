package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBookModel;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import com.bridgelabz.addressbookapp.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//defining the business logic
@Service
@Slf4j
public class AddressBookService implements IAddressBookService {
    List<AddressBookModel> addressBookList = new ArrayList<>();

    @Autowired
    AddressBookRepository addressBookRepo;
    @Autowired
    TokenUtil tokenUtil;

    @Override
    public String welcomeMsg() {
        return "Welcome To the Address Book System, " +
                "we are using Spring Boot to create AddressBookService App";
    }

    ////saving a specific record by using the method save() of CrudRepository
    @Override
    public AddressBookModel addData(AddressBookDto addressBookDto) {
        AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
        //String tokenId = tokenUtil.createToken(addressBookModel.getId());
        return addressBookRepo.save(addressBookModel);
    }

    //    @Override
//    public AddressBookModel getAddressBookData(int id) throws AddressBookException {
//        AddressBookModel addressBookModel = addressBookRepo.findById(id).get();
//        return addressBookModel;
//    }
    //getting a specific record by using the method findById() of CrudRepository
    @Override
    public AddressBookModel getAddressBookData(int id) {
        Optional<AddressBookModel> addressBookModel = addressBookRepo.findById(id);
        if (addressBookModel.isPresent()) {
            return addressBookModel.get();
        } else
            throw new AddressBookException("Id is not present in database");

    }

    @Override
    public List<AddressBookModel> findAddressBookDataByState(String state) {
       addressBookList = addressBookRepo.findAddressBookDataByState(state);
        return addressBookList;
    }


    //getting all the record by using the method findAll() of CrudRepository
    @Override
    public List<AddressBookModel> getAllAddressBookData() {
        // List<AddressBookModel> addressBookList = addressBookRepo.findAll();
        addressBookList = addressBookRepo.findAll();
        return addressBookList;
    }

    //updating a existing record by using the method save() of CrudRepository
    @Override
    public AddressBookModel updateAddressBookData(AddressBookDto addressBookDto, int id) {
        Optional<AddressBookModel> checkId = addressBookRepo.findById(id);
        if (checkId.isPresent()) {
            AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
            addressBookModel.setId(id);
            AddressBookModel addressBookModelUpdate = addressBookRepo.save(addressBookModel);
            return addressBookModelUpdate;
        } else
            throw new AddressBookException("Id is not found ,updation fail");

    }


    //delete a specific record by using the method deleteById() of CrudRepository
    @Override
    public void deleteData(int id) throws AddressBookException {
        Optional<AddressBookModel> checkId = addressBookRepo.findById(id);
        if (checkId.isPresent())
            addressBookRepo.deleteById(id);
        else
            log.info("id not found");
    }

    @Override
    public AddressBookModel getByToken(String token) {
        int userToken = tokenUtil.decodeToken(token);
        Optional<AddressBookModel> addressBookModel = addressBookRepo.findById(userToken);
        if (addressBookModel.isPresent())
            return addressBookRepo.findById(userToken).get();
        else
            throw new AddressBookException("Token is not match");
    }
    //updating a existing record by using the method save() of CrudRepository and Token

    @Override
    public AddressBookModel updateAddressBookDataByToken(int id, String token, AddressBookDto addressBookDto) {
        Optional<AddressBookModel> checkId = checkToken(token);
        if (checkId.isPresent()) {
            AddressBookModel addressBookModel = new AddressBookModel(addressBookDto);
            addressBookModel.setId(id);
            AddressBookModel addressBookModelUpdate = addressBookRepo.save(addressBookModel);
            return addressBookModelUpdate;
        } else
            throw new AddressBookException("Id is not found ,updation fail");

    }
    public Optional<AddressBookModel> checkToken(String token) {
        int userToken = tokenUtil.decodeToken(token);
       // Optional<AddressBookModel> addressBookModelWithToken = addressBookRepo.findById(userToken);
        return addressBookRepo.findById(userToken);
    }

}
