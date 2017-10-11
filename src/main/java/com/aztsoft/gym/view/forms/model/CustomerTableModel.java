/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.view.forms.model;

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
    private final static int TOTAL_COLUMNS = 6;
    private final static int NAME_ROW = 0;
    private final static int AGE_ROW = 1;
    private final static int ADDRESS_ROW = 2;
    private final static int PLAN_ROW = 3;
    private final static int REGISTRATION_DATE_ROW = 4;
    private final static int REGISTRATION_LIMIT_ROW = 5;
    private final Object[] rowsTable = new Object[TOTAL_COLUMNS];

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
            rowsTable[NAME_ROW] = aRecord.getCustomer().getName();
            rowsTable[AGE_ROW] = aRecord.getCustomer().getAge();
            rowsTable[ADDRESS_ROW] = aRecord.getCustomer().getAddress();
            rowsTable[PLAN_ROW] = aRecord.getPlan();
            rowsTable[REGISTRATION_DATE_ROW] = aRecord.getRegistrationDate();
            rowsTable[REGISTRATION_LIMIT_ROW] = aRecord.getRegistrationLimit();
            addRow(rowsTable);
        }
    }

}
