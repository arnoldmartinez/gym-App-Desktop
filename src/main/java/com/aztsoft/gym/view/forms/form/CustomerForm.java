package com.aztsoft.gym.view.forms.form;

import com.aztsoft.gym.controller.CustomerController;
import com.aztsoft.gym.controller.CustomerControllerImp;
import com.aztsoft.gym.domain.Customer;
import com.aztsoft.gym.domain.CustomerRegistration;
import com.aztsoft.gym.view.command.concrete.AddCustomerCommand;
import com.aztsoft.gym.view.command.abstractcommand.Command;
import com.aztsoft.gym.view.forms.abstractview.ViewForm;
import com.toedter.calendar.JDateChooser;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author arnold9108@gmail.com
 */
public final class CustomerForm extends javax.swing.JFrame implements ViewForm {
    private static final int VISIT = 0;
    public FileInputStream imageBlob = null;

    public CustomerForm() {
        runView();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPhoto = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        pnlContractDetail = new javax.swing.JPanel();
        lblTypeRenter = new javax.swing.JLabel();
        cmbPlan = new javax.swing.JComboBox<>();
        jdcLimitDate = new com.toedter.calendar.JDateChooser();
        lblLimitDate = new javax.swing.JLabel();
        txtCost = new javax.swing.JTextField();
        lblCost = new javax.swing.JLabel();
        lblCostRequired = new javax.swing.JLabel();
        pnlCommand = new javax.swing.JPanel();
        btnPostClient = new javax.swing.JButton();
        pnlTittle = new javax.swing.JPanel();
        lblTittle = new javax.swing.JLabel();
        lblRegistrationDate = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        pnlDataClient = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        srcAddress = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        lblnameRequired = new javax.swing.JLabel();
        lblnameRequired2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userIcon.png"))); // NOI18N
        lblPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlPhotoLayout = new javax.swing.GroupLayout(pnlPhoto);
        pnlPhoto.setLayout(pnlPhotoLayout);
        pnlPhotoLayout.setHorizontalGroup(
            pnlPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 112, Short.MAX_VALUE)
            .addGroup(pnlPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPhotoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblPhoto)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pnlPhotoLayout.setVerticalGroup(
            pnlPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
            .addGroup(pnlPhotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPhotoLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pnlContractDetail.setBackground(new java.awt.Color(153, 153, 153));

        lblTypeRenter.setText("Tipo de renta:");

        cmbPlan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPlanItemStateChanged(evt);
            }
        });

        jdcLimitDate.setEnabled(false);

        lblLimitDate.setText("Fecha limite:");

        txtCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostKeyTyped(evt);
            }
        });

        lblCost.setText("Costo:");

        lblCostRequired.setForeground(new java.awt.Color(255, 0, 0));
        lblCostRequired.setText("*");

        javax.swing.GroupLayout pnlContractDetailLayout = new javax.swing.GroupLayout(pnlContractDetail);
        pnlContractDetail.setLayout(pnlContractDetailLayout);
        pnlContractDetailLayout.setHorizontalGroup(
            pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTypeRenter)
                    .addComponent(cmbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcLimitDate, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLimitDate))
                .addGap(18, 18, 18)
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContractDetailLayout.createSequentialGroup()
                        .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCostRequired, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCost))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContractDetailLayout.setVerticalGroup(
            pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTypeRenter)
                    .addComponent(lblLimitDate)
                    .addComponent(lblCost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcLimitDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCostRequired)
                    .addComponent(cmbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCommand.setBackground(new java.awt.Color(153, 153, 153));

        btnPostClient.setText("Agregar");
        btnPostClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostClientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCommandLayout = new javax.swing.GroupLayout(pnlCommand);
        pnlCommand.setLayout(pnlCommandLayout);
        pnlCommandLayout.setHorizontalGroup(
            pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommandLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPostClient, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCommandLayout.setVerticalGroup(
            pnlCommandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCommandLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPostClient, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTittle.setBackground(new java.awt.Color(0, 51, 102));

        lblTittle.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTittle.setForeground(new java.awt.Color(204, 204, 204));
        lblTittle.setText("REGISTRO DE CLIENTE");

        lblRegistrationDate.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        lblRegistrationDate.setForeground(new java.awt.Color(204, 204, 204));
        lblRegistrationDate.setText("Fecha de registro:");

        lblDate.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); // NOI18N
        lblDate.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlTittleLayout = new javax.swing.GroupLayout(pnlTittle);
        pnlTittle.setLayout(pnlTittleLayout);
        pnlTittleLayout.setHorizontalGroup(
            pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTittleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegistrationDate)
                .addGap(18, 18, 18)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlTittleLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(lblTittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTittleLayout.setVerticalGroup(
            pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTittleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlDataClient.setBackground(new java.awt.Color(153, 153, 153));

        lblname.setText("Nombre: ");

        txtName.setName(""); // NOI18N
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        lblAge.setText("Edad:");

        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgeKeyTyped(evt);
            }
        });

        lblAddress.setText("Dirección:");

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        txaAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaAddressKeyTyped(evt);
            }
        });
        srcAddress.setViewportView(txaAddress);

        lblnameRequired.setForeground(new java.awt.Color(255, 0, 0));
        lblnameRequired.setText("*");

        lblnameRequired2.setForeground(new java.awt.Color(255, 0, 0));
        lblnameRequired2.setText(" ");

        javax.swing.GroupLayout pnlDataClientLayout = new javax.swing.GroupLayout(pnlDataClient);
        pnlDataClient.setLayout(pnlDataClientLayout);
        pnlDataClientLayout.setHorizontalGroup(
            pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname)
                    .addComponent(lblAge)
                    .addComponent(lblAddress))
                .addGap(18, 18, 18)
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(srcAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDataClientLayout.createSequentialGroup()
                        .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnameRequired2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblnameRequired, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlDataClientLayout.setVerticalGroup(
            pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblname)
                    .addComponent(lblnameRequired))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnameRequired2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataClientLayout.createSequentialGroup()
                        .addComponent(lblAddress)
                        .addGap(0, 41, Short.MAX_VALUE))
                    .addComponent(srcAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlCommand, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlContractDetail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pnlPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlDataClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDataClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContractDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostClientActionPerformed
        CustomerController controller = new CustomerControllerImp(this);
        Command addCustomer = new AddCustomerCommand(controller);
        addCustomer.execute();
    }//GEN-LAST:event_btnPostClientActionPerformed

    public CustomerRegistration getDataRegistry() {
        CustomerRegistration aRegistry = new CustomerRegistration();
        aRegistry.setCustomer(getDataClient());
        aRegistry.setPlan((String) cmbPlan.getSelectedItem());
        aRegistry.setRegistrationDate(lblDate.getText());
        aRegistry.setRegistrationLimit(getFormatDate(jdcLimitDate));
        if(cmbPlan.getSelectedIndex() > VISIT) {
            aRegistry.setRegistrationLimit(getFormatDate(jdcLimitDate));
        }
        if(StringUtils.isNotBlank(txtCost.getText())) {
            aRegistry.setCost(new Double(txtCost.getText()));
        }
        return aRegistry;
    }
    
    private Customer getDataClient() {
        Customer aClient = new Customer();
        aClient.setName(txtName.getText());
        aClient.setAge(getAgeClient());
        aClient.setAddress(txaAddress.getText());
        aClient.setPhoto(imageBlob);
        return aClient;
    }
    
    private int getAgeClient() {
        return txtAge.getText().equals("") ? 0 : Integer.valueOf(txtAge.getText());
    }

    private String getFormatDate(JDateChooser dateChooser) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return dateChooser == null ? null : format.format(dateChooser.getDate());
    }
    
    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        char alphabeticTyped = evt.getKeyChar();
        if (!Character.isDigit(alphabeticTyped)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAgeKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char keyType = evt.getKeyChar();
        if (!Character.isLetter(keyType) && !Character.isSpace(keyType)) {
            evt.consume();
        }
        if (Character.isLowerCase(keyType)) {
            evt.setKeyChar(Character.toUpperCase(keyType));
        }

    }//GEN-LAST:event_txtNameKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        lblDate.setText(format.format(date));
    }//GEN-LAST:event_formWindowGainedFocus

    private void lblPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoMouseClicked

        JFileChooser imageChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Image", "jpg", "gif");
        imageChooser.setFileFilter(filter);

        int result = imageChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File imagePathFile = imageChooser.getSelectedFile();
        try {
            imageBlob = new FileInputStream(imagePathFile);
        } catch (IOException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon imageIcon = new ImageIcon(imagePathFile.getPath());
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        lblPhoto.setIcon(new ImageIcon(image));

    }//GEN-LAST:event_lblPhotoMouseClicked

    private void txaAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txaAddressKeyTyped
        char keyType = evt.getKeyChar();
        if (Character.isLowerCase(keyType)) {
            evt.setKeyChar(Character.toUpperCase(keyType));
        }
    }//GEN-LAST:event_txaAddressKeyTyped

    private void cmbPlanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPlanItemStateChanged
        switch((String) cmbPlan.getSelectedItem()){
            case "VISITA":
                jdcLimitDate.setEnabled(false);
                break;
            case "SEMANA":
                jdcLimitDate.setEnabled(true);
              break;
            case "QUINCENA":
                jdcLimitDate.setEnabled(true);
                break;
            case "MES":
                jdcLimitDate.setEnabled(true);
                break;
            case "AÑO":
                jdcLimitDate.setEnabled(true);
                break;
        }
    }//GEN-LAST:event_cmbPlanItemStateChanged

    private void txtCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostKeyTyped
        char alphabeticTyped = evt.getKeyChar();
        if (Character.isAlphabetic(alphabeticTyped)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCostKeyTyped

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPostClient;
    public javax.swing.JComboBox<String> cmbPlan;
    public com.toedter.calendar.JDateChooser jdcLimitDate;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCost;
    public javax.swing.JLabel lblCostRequired;
    public javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLimitDate;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRegistrationDate;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblTypeRenter;
    private javax.swing.JLabel lblname;
    public javax.swing.JLabel lblnameRequired;
    private javax.swing.JLabel lblnameRequired2;
    private javax.swing.JPanel pnlCommand;
    private javax.swing.JPanel pnlContractDetail;
    private javax.swing.JPanel pnlDataClient;
    private javax.swing.JPanel pnlPhoto;
    private javax.swing.JPanel pnlTittle;
    private javax.swing.JScrollPane srcAddress;
    public javax.swing.JTextArea txaAddress;
    public javax.swing.JTextField txtAge;
    public javax.swing.JTextField txtCost;
    public javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void loadItemPlan() {
        cmbPlan.addItem("VISITA");
        cmbPlan.addItem("SEMANA");
        cmbPlan.addItem("QUINCENA");
        cmbPlan.addItem("MES");
        cmbPlan.addItem("AÑO");
    }

    public void cleanFields() {
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userIcon.png")));
        txtName.setText("");
        txtAge.setText("");
        txaAddress.setText("");
        cmbPlan.getItemAt(0);
        txtCost.setText("0.0");
    }

    public void showMessage(String aMessage, String tittle, int typeMessage) {
        JOptionPane.showMessageDialog(this, aMessage, tittle, typeMessage);
    }

    public void showFieldRequiredName() {
        lblnameRequired.setVisible(true);
        lblCostRequired.setVisible(true);
    }
    
    public void hideFieldRequiredName() {
        lblnameRequired.setVisible(false);
        lblCostRequired.setVisible(false);
    }

    private void disableLimitDateComponent() {
        jdcLimitDate.setDate(new Date());
    }

    @Override
    public void runView() {
        initComponents();
        loadItemPlan();
        txtCost.setText("0.0");
        hideFieldRequiredName();
        disableLimitDateComponent();
    }

}
