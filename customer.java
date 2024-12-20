/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package customer;

import WRSS.front1;
import MyConnection.MyConnection;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Cedrick Lopez
 */
public class customer extends javax.swing.JFrame {
Connection conn;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form customer
     */ 
    public customer() {
        initComponents();
         MyConnection mycon = new MyConnection();
        conn = mycon.getConnection();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        barangay = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("JVJ 2BEG WATER REFILLING STATION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 18, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 96, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Contact No.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 143, -1, -1));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 93, 250, -1));
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 140, 250, -1));

        barangay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        barangay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Poblacion 1", "Poblacion 2", "Poblacion 3", "Poblacion 4", "Poblacion 5", "Poblacion 6", "Poblacion 7", "Poblacion 8", "Poblacion 9", "Poblacion 10", "Poblacion 11", "Poblacion 12", " " }));
        getContentPane().add(barangay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        button1.setActionCommand("Next");
        button1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button1.setLabel("Next");
        button1.setName(""); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 65, -1));

        button2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button2.setLabel("Back");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        getContentPane().add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 70, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/BGAS.jpeg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
    String customerName = name.getText();
    String contactNumber = number.getText();
    String barangayName = barangay.getSelectedItem().toString();

    if (customerName.isEmpty() || contactNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return;
    }else{

        try {
            pst = conn.prepareStatement("INSERT INTO `customer_info` (name, contact_number, barangay) VALUES (?, ?, ?)");

            pst.setString(1, customerName);
            pst.setString(2, contactNumber);
            pst.setString(3, barangayName);
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Customer data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
            
            pst = conn.prepareStatement("SELECT * FROM customer_info WHERE name = ?");
            pst.setString(1, customerName);
            rst = pst.executeQuery();
            while(rst.next()){
            String ID = rst.getString("id");
            
             containerType1 obj = new containerType1(customerName, ID, barangayName,contactNumber);
            obj.setVisible(true);
            dispose();
            
            }

            // Navigate to the next screen
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving customer data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } 

    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        front1 obj = new front1();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_button2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new customer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> barangay;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name;
    private javax.swing.JTextField number;
    // End of variables declaration//GEN-END:variables
}
