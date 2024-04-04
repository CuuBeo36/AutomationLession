package com.demoblaze.pojo;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String username;
    public String password;

    public void generateUser() {
        Faker faker = new Faker();
        this.setUsername(faker.name().username());
        this.setPassword("Passw@rd123");
    }

}
