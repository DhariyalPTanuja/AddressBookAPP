package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressBookAppApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
        System.out.println("Welcome to the Address Book Application");
        System.out.println("UC1: Create a AddressBook Project and add Dependency");
        System.out.println("UC2: Create a Rest Controller to demonstrate the various HTTP Methods");
        System.out.println("UC3: Introducing DTO and Model ");
        System.out.println(" Introducing service Layer , for hiding and secure the " +
                "functionality create interface in service layer ");
        System.out.println("also add Lombok library to auto generate getter setter ,toString for DTO ");
        log.info("AddressBook App started in {} Environment",
                context.getEnvironment().getProperty("environment"));
        log.info("AddressBook App Database user is {} ",
                context.getEnvironment().getProperty("spring.datasource.username"));
        System.out.println("Apply validation in  DTO");

    }

}
