package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Personne implements Serializable{
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String street;
    private int numberStreet;
    private String city;
    private int postCode;
    private String country;
    private String phoneNumber;
 
    public Personne() {
    }

    public Personne(String firstName, String lastName, LocalDate birthDate, String street, int numberStreet,
            String city, int postCode, String country, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.street = street;
        this.numberStreet = numberStreet;
        this.city = city;
        this.postCode = postCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(int numberStreet) {
        this.numberStreet = numberStreet;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Personne [lastName=" + lastName + ", firstName=" + firstName + ", birthDate=" + birthDate + ",  street=" + street + ", numberStreet=" + numberStreet + ", postCode=" + postCode + ", city=" + city + ", country=" + country + ", phoneNumber=" + phoneNumber + "]";
    }
    

}
