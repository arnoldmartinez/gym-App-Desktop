/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.view.command;

import com.aztsoft.gym.controller.CustomerController;

/**
 *
 * @author vmuser
 */
public class GetAllCustomerRecordsCommand implements Command {
    private final CustomerController controller;

    public GetAllCustomerRecordsCommand(CustomerController controller) {
        this.controller = controller;
    }
    
    @Override
    public void execute() {
        controller.getAllCustomerRecords();
    }
    
}
