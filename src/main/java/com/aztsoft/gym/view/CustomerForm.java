/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aztsoft.gym.view;

import com.aztsoft.gym.controller.CustomerController;
import com.aztsoft.gym.controller.CustomerControllerImp;
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

/**
 *
 * @author windows
 */
public class CustomerForm extends javax.swing.JFrame {

    private final CustomerController customerController;
    public FileInputStream imageBlob = null;

    /**
     * Creates new form ClientForm
     */
    public CustomerForm() {
        customerController = new CustomerControllerImp(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDataClient = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        pnlPhoto = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        pnlAddress = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        srcAddress = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        pnlContractDetail = new javax.swing.JPanel();
        lblTypeRenter = new javax.swing.JLabel();
        cmbPlan = new javax.swing.JComboBox<>();
        pnlCommand = new javax.swing.JPanel();
        btnPostClient = new javax.swing.JButton();
        pnlHeader = new javax.swing.JPanel();
        pnlTittle = new javax.swing.JPanel();
        lblTittle = new javax.swing.JLabel();
        lblRegistrationDate = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

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

        javax.swing.GroupLayout pnlDataClientLayout = new javax.swing.GroupLayout(pnlDataClient);
        pnlDataClient.setLayout(pnlDataClientLayout);
        pnlDataClientLayout.setHorizontalGroup(
            pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataClientLayout.createSequentialGroup()
                        .addComponent(lblAge)
                        .addGap(34, 34, 34)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDataClientLayout.createSequentialGroup()
                        .addComponent(lblname)
                        .addGap(18, 18, 18)
                        .addComponent(txtName)))
                .addContainerGap())
        );
        pnlDataClientLayout.setVerticalGroup(
            pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDataClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAge))
                .addContainerGap(56, Short.MAX_VALUE))
        );

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

        pnlAddress.setBackground(new java.awt.Color(153, 153, 153));

        lblAddress.setText("Dirección:");

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        txaAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txaAddressKeyTyped(evt);
            }
        });
        srcAddress.setViewportView(txaAddress);

        javax.swing.GroupLayout pnlAddressLayout = new javax.swing.GroupLayout(pnlAddress);
        pnlAddress.setLayout(pnlAddressLayout);
        pnlAddressLayout.setHorizontalGroup(
            pnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddressLayout.createSequentialGroup()
                        .addComponent(lblAddress)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(srcAddress))
                .addContainerGap())
        );
        pnlAddressLayout.setVerticalGroup(
            pnlAddressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddressLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(srcAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlContractDetail.setBackground(new java.awt.Color(153, 153, 153));

        lblTypeRenter.setText("Tipo de renta:");

        javax.swing.GroupLayout pnlContractDetailLayout = new javax.swing.GroupLayout(pnlContractDetail);
        pnlContractDetail.setLayout(pnlContractDetailLayout);
        pnlContractDetailLayout.setHorizontalGroup(
            pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTypeRenter)
                    .addComponent(cmbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlContractDetailLayout.setVerticalGroup(
            pnlContractDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContractDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTypeRenter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        pnlHeader.setBackground(new java.awt.Color(0, 51, 102));

        pnlTittle.setBackground(new java.awt.Color(0, 51, 102));

        lblTittle.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        lblTittle.setForeground(new java.awt.Color(204, 204, 204));
        lblTittle.setText("REGISTRO DE CILENTE");

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
                .addGap(137, 137, 137)
                .addComponent(lblTittle)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        pnlTittleLayout.setVerticalGroup(
            pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTittleLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTittleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTittle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDataClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContractDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCommand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDataClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContractDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCommand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPostClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostClientActionPerformed
        customerController.postCustomer();
    }//GEN-LAST:event_btnPostClientActionPerformed

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgeKeyTyped
        char alphabeticTyped = evt.getKeyChar();
        if (Character.isAlphabetic(alphabeticTyped)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtAgeKeyTyped

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        char keyType = evt.getKeyChar();
        if (Character.isDigit(keyType)) {
            getToolkit().beep();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPostClient;
    public javax.swing.JComboBox<String> cmbPlan;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    public javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JLabel lblRegistrationDate;
    private javax.swing.JLabel lblTittle;
    private javax.swing.JLabel lblTypeRenter;
    private javax.swing.JLabel lblname;
    private javax.swing.JPanel pnlAddress;
    private javax.swing.JPanel pnlCommand;
    private javax.swing.JPanel pnlContractDetail;
    private javax.swing.JPanel pnlDataClient;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlPhoto;
    private javax.swing.JPanel pnlTittle;
    private javax.swing.JScrollPane srcAddress;
    public javax.swing.JTextArea txaAddress;
    public javax.swing.JTextField txtAge;
    public javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    public void startView() {
        initComponents();
        loadItemPlan();
    }

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
    }

    public void showMessage(String aMessage, String tittle, int typeMessage) {
        JOptionPane.showMessageDialog(this, aMessage, tittle, typeMessage);
    }

}
