package mobile.loginApp_cucumber.pojo;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public String email;
    public String password;
    public String name;
    public String confirmPassword;
    public static String PASSWORD = "123456";

    public void generateLoginUser() {
        Faker faker = new Faker();
        this.setEmail(faker.internet().emailAddress());
        this.setPassword(faker.internet().password());
    }

    public void generateRegisterUser(){
        Faker faker = new Faker();
        this.setName(faker.name().fullName());
        this.setEmail(faker.internet().emailAddress());
        this.setPassword(PASSWORD);
        this.setConfirmPassword(PASSWORD);
    }
}
