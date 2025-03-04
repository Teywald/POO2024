/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package friends;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class MainForm extends javax.swing.JFrame {


    public MainForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbName = new javax.swing.JLabel();
        lbNumber = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbName.setText("Name");

        lbNumber.setText("Number");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setText("Read");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(31, 31, 31)
                        .addComponent(btnRead)
                        .addGap(37, 37, 37)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbName)
                            .addComponent(lbNumber))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName)
                            .addComponent(txtNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))))
                .addGap(37, 37, 37)
                .addComponent(btnClear)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumber)
                    .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnRead)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        
    try {
            String newName = txtName.getText();
            long newNumber = Long.parseLong(txtNumber.getText());
            String nameNumberString;
            int index;
            String name;
            long number;
            
            File file = new File("friendsContact.txt");
            
            if (file.exists()==false) {
 
                // Create a new file if not exists.
                file.createNewFile();
            }
 
            // Opening file in reading and write mode.
 
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
 

            while (raf.getFilePointer() < raf.length()) {
 
                // reading line from the file.
                nameNumberString = raf.readLine();
 
                // splitting the string to get name and
                // number
                String[] lineSplit = nameNumberString.split("!");
 
                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);
 
                // if condition to find existence of record.
                if (name.equals(newName) || number == newNumber) {
                    found = true;
                    break;
                }
            }
 
            if (found == false) {
 
                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString = newName + "!" + String.valueOf(newNumber);
 
                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);
 
                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());
 
                // Print the message
                JOptionPane.showMessageDialog(null,"Friend added", "New Friend",JOptionPane.INFORMATION_MESSAGE);
 
                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {
 
                // Closing the resources.
                raf.close();
 
                // Print the message
                JOptionPane.showMessageDialog(null,"The friend still exits","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
 
    catch (IOException ioe) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException nef) {
        JOptionPane.showMessageDialog(null, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        // TODO add your handling code here:
            
        try {
        File file = new File("friendsContact.txt");

        if (!file.exists() || file.length() == 0) {
            JOptionPane.showMessageDialog(null, "No contacts found.", "Contacts", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "r");
        StringBuilder contacts = new StringBuilder();
        
        // Leer cada línea del archivo y agregarla a la lista de contactos
        while (raf.getFilePointer() < raf.length()) {
            String nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            if (lineSplit.length != 2) continue; // Evita errores si hay líneas mal formateadas

            String name = lineSplit[0];
            String number = lineSplit[1];

            contacts.append("Name: ").append(name).append("\n");
            contacts.append("Number: ").append(number).append("\n\n");
        }

        raf.close();

        // Mostrar los contactos en una ventana emergente
        JOptionPane.showMessageDialog(null, contacts.toString(), "Friend List", JOptionPane.INFORMATION_MESSAGE);
        
    } catch (IOException ioe) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + ioe.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException nef) {
        JOptionPane.showMessageDialog(null, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
        String inputName = txtName.getText().trim();
        String newNumber = txtNumber.getText().trim();

        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "No contacts found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        StringBuilder updatedContent = new StringBuilder();
        boolean found = false;

        // Leer el archivo y actualizar el número si se encuentra el contacto
        while (raf.getFilePointer() < raf.length()) {
            String nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            if (lineSplit.length != 2) continue; // Evita errores si hay líneas mal formateadas

            String name = lineSplit[0];

            if (name.equals(inputName)) {
                // Si el nombre coincide, actualizar el número
                nameNumberString = name + "!" + newNumber;
                found = true;
            }

            updatedContent.append(nameNumberString).append(System.lineSeparator());
        }

        // Si se encontró el contacto, sobrescribir el archivo
        if (found) {
            raf.setLength(0); // Borra todo el contenido del archivo original
            raf.writeBytes(updatedContent.toString());
            JOptionPane.showMessageDialog(null, "Friend updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Friend not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        raf.close();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try {
        String inputName = txtName.getText().trim();
        File file = new File("friendsContact.txt");

        if (!file.exists()) {
            JOptionPane.showMessageDialog(null, "No contacts found.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        StringBuilder updatedContent = new StringBuilder();
        boolean found = false;

        // Leer el archivo y omitir el contacto a eliminar
        while (raf.getFilePointer() < raf.length()) {
            String nameNumberString = raf.readLine();
            String[] lineSplit = nameNumberString.split("!");

            if (lineSplit.length != 2) continue; // Evita errores si hay líneas mal formateadas

            String name = lineSplit[0];

            if (name.equals(inputName)) {
                found = true; // Se encontró el contacto y no se guardará
                continue;
            }

            updatedContent.append(nameNumberString).append(System.lineSeparator());
        }

        // Si se encontró el contacto, sobrescribir el archivo
        if (found) {
            raf.setLength(0); // Borra todo el contenido del archivo original
            raf.writeBytes(updatedContent.toString());
            JOptionPane.showMessageDialog(null, "Friend deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Friend not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        raf.close();
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtNumber.setText("");
        txtName.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumber;
    // End of variables declaration//GEN-END:variables
}