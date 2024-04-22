package com.luma.pojo;


import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckoutUser {
    public String email;
    public String firstName;
    public String lastName;
    public String company;
    public String street0;
    public String street1;
    public String street2;
    public String city;
    public String state;
    public String zipCode;
    public String country;
    public String phoneNo;
    public String ship;

    public void generateCheckOutUser() {
        Faker faker = new Faker();
        this.setEmail(faker.internet().emailAddress());
        this.setFirstName(faker.name().firstName());
        this.setLastName(faker.name().lastName());
        this.setCompany(faker.company().name());
        this.setStreet0(faker.address().streetName());
        this.setStreet1(faker.address().streetPrefix());
        this.setStreet2(faker.address().streetAddress());
        this.setCity(faker.address().city());
        this.setZipCode(faker.address().zipCode());
        this.setPhoneNo(faker.phoneNumber().phoneNumber());
    }
}
