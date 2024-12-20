/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package customer;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import MyConnection.MyConnection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.JSpinner;


/**
 *
 * @author Juan Cedrick Lopez
 */
public class containerType1 extends javax.swing.JFrame {
Connection conn;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form containerType1
     */

 String cname;
 String cnum;
 String bname;
 String phone;
 int cumulativeTotal = 0;
     public containerType1(String customerName, String ID, String barangayName, String contactNumber) {
        initComponents();
         MyConnection mycon = new MyConnection();
        conn = mycon.getConnection();
        this.cname = customerName;
        this.cnum = ID;
        this.phone = contactNumber;
        this.bname = barangayName;
        initializeMappings();
       
        
        
        
    }

 private void purchaseContainer(String containerName) {
    try {
        // Get the spinner and price for the product
        JSpinner spinner = productSpinnerMap.get(containerName);
        int price = productPriceMap.get(containerName);

        // Get the quantity from the spinner
        int quantity = (int) spinner.getValue();

        // Calculate the total price
        int totalPrice = quantity * price;

        // Add to cumulative total
        cumulativeTotal += totalPrice;

        // Track the product
        selectedProducts.add(containerName);

        // Display in the text area
        StringBuilder output = new StringBuilder();
        output.append("\n").append(containerName).append("\n");
        output.append("Quantity: ").append(quantity).append("\n");
        output.append("Total Price: ").append(totalPrice).append("\n");
        
         jTextField1.setText(String.valueOf(cumulativeTotal));
        txtprint2.append(output.toString());

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "An error occurred while processing the purchase: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
 
 
 




     Set<String> selectedProducts = new HashSet<>();
     Map<String, JSpinner> productSpinnerMap = new HashMap<>();
    Map<String, Integer> productPriceMap = new HashMap<>();
    
    
    private void initializeMappings() {
    // Map product names to their spinners
    productSpinnerMap.put("8 Liters", jSpinner1);
    productSpinnerMap.put("21 Liters Dispenser", jSpinner2);
    productSpinnerMap.put("21 Liters Container", jSpinner3);
    productSpinnerMap.put("31 Liters", jSpinner4);

    // Map product names to their prices
    productPriceMap.put("8 Liters", 20);
    productPriceMap.put("21 Liters Dispenser", 30);
    productPriceMap.put("21 Liters Container", 30);
    productPriceMap.put("31 Liters", 40);
    
  
}
    
    


private void saveToDatabase() {
 String mop = (String) jComboBox1.getSelectedItem();

    try {
        String sql = "INSERT INTO sales (customer_id, name, container, quantity, total, MOP) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        for (String product : selectedProducts) {
            JSpinner spinner = productSpinnerMap.get(product);
            int quantity = (int) spinner.getValue();
            int price = productPriceMap.get(product);
            int totalPrice = quantity * price;
            
            statement.setString(1, cnum);
            statement.setString(2, cname); // Customer name
            statement.setString(3, product); // Product name
            statement.setInt(4, quantity); // Quantity
            statement.setInt(5, totalPrice); // Total price
            statement.setString(6,mop);
            statement.executeUpdate();
        }
        String sql2 = "INSERT INTO deliveries(customer_id, barangay, status) VALUES(?,?,?)";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setString(1, cnum);
            statement2.setString(2, bname);
            statement2.setString(3, "delivered");
            statement2.executeUpdate();

        JOptionPane.showMessageDialog(this, "Purchase Successful!");
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this,
            "Error saving to database: " + ex.getMessage(),
            "Database Error",
            JOptionPane.ERROR_MESSAGE);
    }
}
 public containerType1(){ 
   
 }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        l8 = new java.awt.Button();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        L21t1 = new java.awt.Button();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner3 = new javax.swing.JSpinner();
        l21t2 = new java.awt.Button();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        l31 = new java.awt.Button();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        button5 = new java.awt.Button();
        button6 = new java.awt.Button();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtprint2 = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel());
        jPanel1.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Quantity:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 64, -1));

        l8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        l8.setLabel("Purchase");
        l8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l8ActionPerformed(evt);
            }
        });
        jPanel1.add(l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("P20");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 30, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("8 Liters");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/Small-1.jpg"))); // NOI18N
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 163));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 280, 200));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("JVJ 2BEG REFILLING SALES SYSTEM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 450, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Quantity:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel());
        jPanel2.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, -1));

        L21t1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        L21t1.setLabel("Purchase");
        L21t1.setName("Purchase"); // NOI18N
        L21t1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                L21t1ActionPerformed(evt);
            }
        });
        jPanel2.add(L21t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("P30");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("21 Liters");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 25, -1, -1));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 171, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/Medium-1.jpg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 135, 140));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 81, 270, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 22, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Quantity:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel());
        jPanel3.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, -1, -1));

        l21t2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        l21t2.setLabel("Purchase");
        l21t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l21t2ActionPerformed(evt);
            }
        });
        jPanel3.add(l21t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("P30");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("21 Liters");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 93, -1, -1));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 65, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/Large-1.jpg"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 280, 190));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 32, -1, -1));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Quantity:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner4.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jSpinner4AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jPanel4.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        l31.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        l31.setLabel("Purchase");
        l31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l31ActionPerformed(evt);
            }
        });
        jPanel4.add(l31, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("P40");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("31 Liters");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/XL (2).jpg"))); // NOI18N
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 280, 190));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash on Pickup", "Gcash", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Mode of payment:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));

        button5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button5.setLabel("Buy");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });
        getContentPane().add(button5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 84, -1));

        button6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button6.setLabel("Back");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });
        getContentPane().add(button6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 80, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Order Info");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        txtprint2.setEditable(false);
        txtprint2.setColumns(20);
        txtprint2.setRows(5);
        txtprint2.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtprint2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 106, 230, 200));

        jLabel27.setText("Total:");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 30, 30));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 310, 130, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/BGAS.jpeg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        saveToDatabase();
        String text = txtprint2.getText();
        Receipt1 r = new Receipt1(text);
        jSpinner1.setValue(0);
        jSpinner2.setValue(0);
        jSpinner3.setValue(0);
        jSpinner4.setValue(0);
        r.setVisible(true);
        txtprint2.setText("");
        
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        customer obj = new customer();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_button6ActionPerformed

    private void jSpinner4AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSpinner4AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jSpinner4AncestorAdded
  
    private void l8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l8ActionPerformed
    purchaseContainer("8 Liters");
    }//GEN-LAST:event_l8ActionPerformed

    private void L21t1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_L21t1ActionPerformed
purchaseContainer("21 Liters Dispenser");
    }//GEN-LAST:event_L21t1ActionPerformed

    private void l21t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l21t2ActionPerformed
      purchaseContainer("21 Liters Container");
    }//GEN-LAST:event_l21t2ActionPerformed

    private void l31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l31ActionPerformed
    purchaseContainer("31 Liters");
    }//GEN-LAST:event_l31ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedOption = (String) jComboBox1.getSelectedItem();
        String tamount = jTextField1.getText().toString();
    
    // Check if "Gcash" is selected
    if ("Gcash".equals(selectedOption)) {
        // Open the Gcash JFrame
        Gcash gcashForm = new Gcash(cname, cnum, phone, tamount);  // Create an instance of the Gcash form
        gcashForm.setVisible(true);      // Make the form visible
    }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(containerType1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new containerType1().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button L21t1;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTextField jTextField1;
    private java.awt.Button l21t2;
    private java.awt.Button l31;
    private java.awt.Button l8;
    private javax.swing.JTextArea txtprint2;
    // End of variables declaration//GEN-END:variables

    private int getPriceForProduct(String product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private JSpinner getSpinnerForProduct(String product) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
