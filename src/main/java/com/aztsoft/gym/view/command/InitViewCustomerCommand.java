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
public class InitViewCustomerCommand implements Command {

    private final CustomerController customerController;
    
    public InitViewCustomerCommand(CustomerController customerController) {
        this.customerController = customerController;
    }
    
    @Override
    public void execute() {
        
    }
    
}
