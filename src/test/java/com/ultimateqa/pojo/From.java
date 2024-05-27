package com.ultimateqa.pojo;


import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class From {
    public String name0;
    public String message0;
    public String name1;
    public String message1;

    public void generateForm0(){
        Faker faker = new Faker();
        this.setName0(faker.name().name());
        this.setMessage0(faker.random().toString());
    }
    public void generateForm1(){
        Faker faker = new Faker();
        this.setName1(faker.name().name());
        this.setMessage1(faker.random().toString());
    }
}
