package admin;
import MyConnection.MyConnection;
import WRSS.front1;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;


/**
 *
 * @author Juan Cedrick Lopez
 */
public class login extends javax.swing.JFrame {
Connection conn;
PreparedStatement pst;
ResultSet rst;
  

    /**
     * Creates new form login
     */
    public login() {
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

        username = new java.awt.TextField();
        txtLogin = new java.awt.Button();
        txtSignup = new java.awt.Button();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtShowPass = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 142, 172, -1));

        txtLogin.setActionCommand("LOGIN");
        txtLogin.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtLogin.setLabel("LOGIN");
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        getContentPane().add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 244, 172, -1));

        txtSignup.setActionCommand("SIGN UP");
        txtSignup.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtSignup.setLabel("SIGN UP");
        txtSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSignupActionPerformed(evt);
            }
        });
        getContentPane().add(txtSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 278, 172, -1));

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 185, 172, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("username");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 142, 60, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("password");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        txtShowPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtShowPass.setText("show password");
        txtShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtShowPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtShowPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 213, -1, -1));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("JVJ 2BEG REFILLING SALES SYSTEM");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, -1));

        button1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        button1.setLabel("Back");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        getContentPane().add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 60, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/admin/img.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
 
        String user = username.getText();  // Get the username from the text field
        String pass = String.valueOf(password.getPassword());  // Get the password from the password field
        
        // Validation for empty fields
        if (user.isEmpty() && pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "REQUIRED USERNAME AND PASSWORD");
            return;  // Exit the method early if both fields are empty
        } else if (user.isEmpty()) {
            JOptionPane.showMessageDialog(this, "REQUIRED USERNAME");
            return;
        } else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "REQUIRED PASSWORD");
            return;
        }else{
            try{
                pst = conn.prepareStatement("SELECT * FROM register WHERE username=? AND password = ?");
                pst.setString(1, user);
                pst.setString(2, pass);
                rst = pst.executeQuery();
                
              if(rst.next()==true){
               JOptionPane.showMessageDialog(null, "Welcome, Admin!");
               admin h = new admin();
               h.setVisible(true);
               this.dispose();
           }else{
               JOptionPane.showMessageDialog(null, "UNAUTHORIZED ACCCESS!");
               username.setText("");
               password.setText("");
               password.requestFocus();
           }
            }catch(SQLException e){
                e.printStackTrace();
            }
        } 
        
    }//GEN-LAST:event_txtLoginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void txtSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSignupActionPerformed
    signup signupFrame = new signup();
    signupFrame.setVisible(true);
    this.setVisible(false);
    }//GEN-LAST:event_txtSignupActionPerformed

    private void txtShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtShowPassActionPerformed
     if (txtShowPass.isSelected()) {
        password.setEchoChar((char) 0);  // This shows the password as plain text
    } else {
        password.setEchoChar('*');  // This hides the password as asterisks
    }
    }//GEN-LAST:event_txtShowPassActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        front1 obj = new front1();
        obj.setVisible(true);
        dispose();
    }//GEN-LAST:event_button1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField password;
    private java.awt.Button txtLogin;
    private javax.swing.JRadioButton txtShowPass;
    private java.awt.Button txtSignup;
    private java.awt.TextField username;
    // End of variables declaration//GEN-END:variables
}
