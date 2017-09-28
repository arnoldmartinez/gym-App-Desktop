/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.view;

import com.aztsoft.gym.domain.CustomerRegistration;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author windows
 */
public class CustomerTableModel extends DefaultTableModel {

    private static final String NAME_COLUMN = "NOMBRE";
    private static final String AGE_COLUMN = "EDAD";
    private static final String ADDRESS_COLUMN = "DIRECCION";
    private static final String PLAN_COLUMN = "PLAN";
    private static final String REGISTRATION_DATE_COLUMN = "FECHA DE REGISTRO";
    private static final String REGISTRATION_LIMIT_COLUMN = "FECHA LIMITE";

    private Object[] rowsTable = new Object[6];

    public CustomerTableModel() {

        addColumn(NAME_COLUMN);
        addColumn(AGE_COLUMN);
        addColumn(ADDRESS_COLUMN);
        addColumn(PLAN_COLUMN);
        addColumn(REGISTRATION_DATE_COLUMN);
        addColumn(REGISTRATION_LIMIT_COLUMN);

    }
    
    public void addRecordAll(List<CustomerRegistration> records) {

        for(CustomerRegistration aRecord : records){

            rowsTable[0] = aRecord.getCustomer().getName();
            rowsTable[1] = aRecord.getCustomer().getAge();
            rowsTable[2] = aRecord.getCustomer().getAddress();
            rowsTable[3] = aRecord.getPlan();
            rowsTable[4] = aRecord.getRegistrationDate();
            rowsTable[5] = aRecord.getRegistrationLimit();

            addRow(rowsTable);
        }
    }

}
