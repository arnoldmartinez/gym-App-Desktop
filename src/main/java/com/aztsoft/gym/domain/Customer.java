/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.domain;

import java.io.FileInputStream;
import java.util.UUID;

/**
 * @author arnold9108@gmail.com
 */
public class Customer {

    private String id;
    private String name;
    private int age;
    private String address;
    private FileInputStream photo;

    public Customer() {
        this.id = UUID.randomUUID().toString();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public FileInputStream getPhoto() {
        return photo;
    }

    public void setPhoto(FileInputStream photo) {
        this.photo = photo;
    }

}
