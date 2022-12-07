package com.bridgelabz.addressbookapp.dto;

import lombok.ToString;

public @ToString class AddressBookDto {
   public String firstName;
    public String lastName;
    public long phoneNumber;
    public String address;
    public String city;
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
