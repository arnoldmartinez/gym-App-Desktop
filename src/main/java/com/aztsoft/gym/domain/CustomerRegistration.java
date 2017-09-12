package com.aztsoft.gym.domain;

/**
 * Created by arnold9108@gmail.com on 28/08/17.
 */
public class CustomerRegistration {

    private String registrationDate;
    private Customer customer;
    private String registrationLimit;
    private double cost;

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

    public String getRegistrationLimit() {
        return registrationLimit;
    }

    public void setRegistrationLimit(String registrationLimit) {
        this.registrationLimit = registrationLimit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
