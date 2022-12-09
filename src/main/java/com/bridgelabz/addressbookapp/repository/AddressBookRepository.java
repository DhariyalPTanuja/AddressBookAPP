package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressBookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
//repository that extends JpaRepository
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer>{

    @Query(value = "select * from address_book where state = state "  ,nativeQuery = true)
    List<AddressBookModel> findAddressBookDataByState(String state);

}
