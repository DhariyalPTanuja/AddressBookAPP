package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.*;
import lombok.ToString;

public @ToString class AddressBookDto {
    @NotEmpty(message = "First Name is not null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "First name must be start with capital letter and minimum 3 char")
    public String firstName;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "Last name must be start with capital letter and minimum 3 char")
    public String lastName;
   @Pattern(regexp = "^(\\+\\d{1,2}[-]?)[7-9][0-9]{9}$",message = "Number pattern like this +81 7567897654")
    public String phoneNumber;
    @NotEmpty(message = "Email is not empty")
    public String email;
    @NotEmpty(message = "Address not empty")
    public String address;
    @NotEmpty(message = "Address not empty")
    public String city;
    public String district;
//    @Size(min = 0,max = 6,message = "zip code size 6")
//    @NotNull(message = "please enter zip code")
    public int zipCode;
    public String state;

    public AddressBookDto() {
    }

    public AddressBookDto(String firstName, String lastName, String phoneNumber, String email, String address, String city, String district, int zipCode, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
    }
}
