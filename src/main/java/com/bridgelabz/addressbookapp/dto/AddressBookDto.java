package com.bridgelabz.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.ToString;

public @ToString class AddressBookDto {
   @NotEmpty(message = "First Name is not null")
   @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "First name must be start with capital letter and minimum 3 char")
   public String firstName;
   @Pattern(regexp = "^[A-Z]{1}[a-zA-z]{3,}$", message = "Last name must be start with capital letter and minimum 3 char")
    public String lastName;

    public long phoneNumber;

    public String address;
    public String city;
    @NotBlank(message = "zip code is not Blank")
    @Pattern(regexp = "^[0-9]{6}", message = "only 6 digit allow in Zip code ")
    public int zipCode;
    public String state;

    public AddressBookDto() {
    }

 public AddressBookDto(String firstName, String lastName, long phoneNumber, String address, String city, int zipCode, String state) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.phoneNumber = phoneNumber;
  this.address = address;
  this.city = city;
  this.zipCode = zipCode;
  this.state = state;
 }
}
