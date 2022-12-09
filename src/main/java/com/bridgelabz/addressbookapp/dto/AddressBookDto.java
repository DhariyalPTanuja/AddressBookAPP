package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

public @ToString class AddressBookDto {
   @NotEmpty(message = "First Name is not null")
   @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "First name must be start with capital letter and minimum 3 char")
   public String firstName;
   @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "Last name must be start with capital letter and minimum 3 char")
    public String lastName;

    public long phoneNumber;
   // @NotEmpty(message = "Phonenumber is not empty")
    public String email;

    public String address;
    public String city;
    public String district;
   // @Pattern(regexp = "^[0-9]{6}$" , message = "only 6 digit allow in zipCode")
    public int zipCode;
    public String state;

    public AddressBookDto() {
    }

 public AddressBookDto(String firstName, String lastName, long phoneNumber,String email, String address, String city, String district, int zipCode, String state) {
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
