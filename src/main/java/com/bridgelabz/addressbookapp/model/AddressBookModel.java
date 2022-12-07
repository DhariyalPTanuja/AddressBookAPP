package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Address_Book")
public @Data class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String address;
    private String city;
    private int zipCode;
    private String state;


    public AddressBookModel() {
    }

    public void updateAddressBookModel(AddressBookDto addressBookDto) {
        this.firstName = addressBookDto.firstName;
        this.lastName = addressBookDto.lastName;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.address = addressBookDto.address;
        this.city = addressBookDto.city;
        this.zipCode = addressBookDto.zipCode;
        this.state = addressBookDto.state;
    }

    public AddressBookModel(AddressBookDto addressBookDto) {
      this.updateAddressBookModel(addressBookDto);
    }
}