package ppyrczak.carrental.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name is mandatory")
    private String name;


    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    private String phoneNumber;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "Home number is mandatory")
    private String homeNumber;

    @NotBlank(message = "Password is mandatory")
    private String password;
/*
    public User() {}

    public User(Long id,
                String name,
                String surname,
                String email,
                String phoneNumber,
                String city,
                String street,
                String homeNumber,
                String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.password = password;
    }

    public User(String name, String email, String surname, String phoneNumber, String city, String street, String homeNumber, String password) {
        this.name = name;
        this.email = email;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
    }*/
}