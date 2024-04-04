package com.parabanknew.pojo;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String phoneNumber;
    public String ssn;
    public String username;
    public String password;
    public String confirmPassword;

    public void generateUser() {
        Faker faker = new Faker();
        this.setFirstName(faker.name().firstName());
        this.setLastName(faker.name().lastName());
        this.setAddress(faker.address().streetAddress());
        this.setCity(faker.address().city());
        this.setState(faker.address().state());
        this.setZipCode(faker.address().zipCode());
        this.setPhoneNumber(faker.phoneNumber().phoneNumber());
        this.setSsn(faker.idNumber().ssnValid());
        this.setUsername(faker.name().username());
        this.setPassword("Passw@rd123");
    }
}
