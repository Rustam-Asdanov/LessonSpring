package com.king.example.data;

import javax.validation.constraints.*;

public class Customer {
    @NotNull(message="name shuld not be empty")
    @Size(min=2, message="is required")
    private String login;

    @Min(value=0, message="age shuld be greater than 0")
    private int age;

    @Pattern(regexp = "^[a-z0-9_\\-]+$", message = "minimum one letter in uppercase")
    private String password;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "you forget @")
    private String email;

    public Customer() {
    }

    public Customer(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
