package com.aztsoft.gym.domain;

/**
 * Created by vmuser on 28/08/17.
 */
public class CustomerRegistration {

    private String registrationDate;
    private Customer customer;

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
