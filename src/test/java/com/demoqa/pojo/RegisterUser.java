package com.demoqa.pojo;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUser {
    public String firstName;
    public String lastName;
    public String email;
    public String mobile;
    public String dateOfBirth;
    public String subject;
    public String currentAddress;

    public void generateRegisterUser(){
        Faker faker = new Faker();
        this.setFirstName(faker.name().firstName());
        this.setLastName(faker.name().lastName());
        this.setEmail(faker.internet().emailAddress());
        this.setMobile(faker.phoneNumber().subscriberNumber(10));
        this.setDateOfBirth(faker.date().birthday().toString());
        this.setSubject(faker.random().toString());
        this.setCurrentAddress(faker.address().fullAddress());
    }
}
