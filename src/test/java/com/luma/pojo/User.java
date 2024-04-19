package com.luma.pojo;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String confirmPassword;

    public void generateUser() {
        Faker faker = new Faker();
        this.setFirstName(faker.name().firstName());
        this.setLastName(faker.name().lastName());
        this.setEmail(faker.internet().emailAddress());
        this.setPassword("Passw@rd123");
        this.setConfirmPassword("Passw@rd123");
    }
}
