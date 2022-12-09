package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Address_Book")
public @Data class AddressBookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String email;
    private String address;
    private String city;
    private String district;
    private int zipCode;
    private String state;


    public AddressBookModel() {
    }

    public void updateAddressBookModel(AddressBookDto addressBookDto) {
        this.firstName = addressBookDto.firstName;
        this.lastName = addressBookDto.lastName;
        this.phoneNumber = addressBookDto.phoneNumber;
        this.email = addressBookDto.email;
        this.address = addressBookDto.address;
        this.city = addressBookDto.city;
        this.district = addressBookDto.district;
        this.zipCode = addressBookDto.zipCode;
        this.state = addressBookDto.state;
    }

    public AddressBookModel(AddressBookDto addressBookDto) {
        this.updateAddressBookModel(addressBookDto);
    }
}