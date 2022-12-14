/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import view.App;
import BackEnd.MySqlConnect;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.DocumentListener;

public class Login extends javax.swing.JFrame implements DocumentListener,Constants {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        setBounds(200,70,800,550);
        
        //Adding the listeners
        jtfEmail.getDocument().addDocumentListener(this);
        
        connection = MySqlConnect.connectDb();
        if(connection == null)
            JOptionPane.showMessageDialog(null,"Some problem with connecting the database");
        
        jfLoading = new Loading();
        jfRegistration = new registration();
        jfLoading.setLocationRelativeTo(null);
        jfLoading.setSize(1366,768);
        timer = new Timer(6500,new LoadingTimer());
        timer.setRepeats(false);
    }
    private void close()
    {
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }
    private void processLogin()
    {
        if(jtfEmail.getText().equals("") || jtfPassword.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Email or Password field is empty");
            return;
        }
        if(jtfPassword.getText().length() < 8)
        {
            JOptionPane.showMessageDialog(null, "The  Password must be 8 characters long");
            return;
        }
        try {
           String sql = "SELECT * FROM login WHERE email = ? AND password = ?";
           System.out.println("Check");
           preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, jtfEmail.getText());
           preparedStatement.setString(2, jtfPassword.getText());
           resultSet = preparedStatement.executeQuery();
           if(resultSet.next())
           {
                close();
                jfLoading.setVisible(true);
                
                timer.start();
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Incorrect Name or Password!!Please try again.");
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sql problem : " + e.getMessage());
        }
    }

    private void checkFields()
    {
        if(jtfEmail.getText().length() == 0 || jtfEmail.getText().equals(EMAIL_TEXT_FIELD_PLACEHOLDER) || Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-\\+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$").matcher(jtfEmail.getText()).matches())
        {
            jsEmail.setBackground(new Color(236,240,241));
            jtfEmail.setForeground(new Color(236,240,241));
            return;
        }
        jsEmail.setBackground(new Color(255,102,153));
        jtfEmail.setForeground(new Color(255,102,153));
    }
    @Override
    public void insertUpdate(javax.swing.event.DocumentEvent e) 
    {
        checkFields();
    }

    @Override
    public void removeUpdate(javax.swing.event.DocumentEvent e) 
    {
        checkFields();
    }

    @Override
    public void changedUpdate(javax.swing.event.DocumentEvent e) {}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogin = new javax.swing.JPanel();
        jlSignIn = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jsEmail = new javax.swing.JSeparator();
        jsPassword = new javax.swing.JSeparator();
        jlPassword = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JPasswordField();
        jbLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbLogin1 = new javax.swing.JButton();
        jpDisplay = new javax.swing.JPanel();
        jlTitle = new javax.swing.JLabel();
        jsTitle = new javax.swing.JSeparator();
        jlAnimation = new javax.swing.JLabel();
        jlQuote = new javax.swing.JLabel();
        jsQuote = new javax.swing.JSeparator();
        jsQuote2 = new javax.swing.JSeparator();
        jlClose = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0,0,800,550,30,30));
        getContentPane().setLayout(null);

        jpLogin.setBackground(new java.awt.Color(236, 83, 93));
        jpLogin.setLayout(null);

        jlSignIn.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jlSignIn.setForeground(new java.awt.Color(236, 240, 241));
        jlSignIn.setText("Sign In");
        jpLogin.add(jlSignIn);
        jlSignIn.setBounds(70, 80, 70, 26);

        jtfEmail.setBackground(new java.awt.Color(236, 83, 93));
        jtfEmail.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
        jtfEmail.setForeground(new java.awt.Color(236, 240, 241));
        jtfEmail.setBorder(null);
        jtfEmail.setCaretColor(new java.awt.Color(236, 240, 241));
        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
            }
        });
        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });
        jtfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfEmailKeyTyped(evt);
            }
        });
        jpLogin.add(jtfEmail);
        jtfEmail.setBounds(70, 190, 270, 40);

        jlEmail.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jlEmail.setForeground(new java.awt.Color(236, 240, 241));
        jlEmail.setText("NAME :");
        jpLogin.add(jlEmail);
        jlEmail.setBounds(70, 150, 70, 30);

        jsEmail.setBackground(new java.awt.Color(236, 240, 241));
        jpLogin.add(jsEmail);
        jsEmail.setBounds(70, 230, 270, 2);

        jsPassword.setBackground(new java.awt.Color(236, 240, 241));
        jpLogin.add(jsPassword);
        jsPassword.setBounds(70, 370, 270, 2);

        jlPassword.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jlPassword.setForeground(new java.awt.Color(236, 240, 241));
        jlPassword.setText("PASSWORD : ");
        jpLogin.add(jlPassword);
        jlPassword.setBounds(70, 290, 130, 30);

        jtfPassword.setBackground(new java.awt.Color(236, 83, 93));
        jtfPassword.setFont(new java.awt.Font("Century Gothic", 0, 19)); // NOI18N
        jtfPassword.setForeground(new java.awt.Color(236, 240, 241));
        jtfPassword.setText("PASSWORD");
        jtfPassword.setBorder(null);
        jtfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfPasswordFocusLost(evt);
            }
        });
        jtfPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPasswordActionPerformed(evt);
            }
        });
        jpLogin.add(jtfPassword);
        jtfPassword.setBounds(70, 330, 270, 40);

        jbLogin.setBackground(new java.awt.Color(86, 61, 124));
        jbLogin.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jbLogin.setForeground(new java.awt.Color(236, 240, 241));
        jbLogin.setText("Sign Up");
        jbLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jbLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbLoginMouseExited(evt);
            }
        });
        jbLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSignUpActionPerformed(evt);
            }
        });
        jpLogin.add(jbLogin);
        jbLogin.setBounds(280, 500, 97, 40);

        jLabel1.setText("Not a User?");
        jpLogin.add(jLabel1);
        jLabel1.setBounds(180, 520, 80, 14);

        jbLogin1.setBackground(new java.awt.Color(86, 61, 124));
        jbLogin1.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        jbLogin1.setForeground(new java.awt.Color(236, 240, 241));
        jbLogin1.setText("Login");
        jbLogin1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jbLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbLogin1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbLogin1MouseExited(evt);
            }
        });
        jbLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLogin1ActionPerformed(evt);
            }
        });
        jpLogin.add(jbLogin1);
        jbLogin1.setBounds(70, 430, 97, 40);

        getContentPane().add(jpLogin);
        jpLogin.setBounds(0, 0, 400, 550);

        jpDisplay.setBackground(new java.awt.Color(255, 255, 255));
        jpDisplay.setLayout(null);

        jlTitle.setFont(new java.awt.Font("Century Gothic", 0, 50)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(236, 83, 93));
        jlTitle.setText("Mindworks");
        jpDisplay.add(jlTitle);
        jlTitle.setBounds(80, 50, 260, 62);

        jsTitle.setBackground(new java.awt.Color(236, 83, 93));
        jpDisplay.add(jsTitle);
        jsTitle.setBounds(80, 110, 250, 20);

        jlAnimation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/TT.png"))); // NOI18N
        jpDisplay.add(jlAnimation);
        jlAnimation.setBounds(75, 150, 270, 255);

        jlQuote.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jlQuote.setForeground(new java.awt.Color(236, 83, 93));
        jlQuote.setText("Be Smart.Generate Automatic Timetable");
        jpDisplay.add(jlQuote);
        jlQuote.setBounds(40, 440, 340, 22);

        jsQuote.setBackground(new java.awt.Color(236, 83, 93));
        jpDisplay.add(jsQuote);
        jsQuote.setBounds(60, 470, 280, 2);

        jsQuote2.setBackground(new java.awt.Color(236, 83, 93));
        jpDisplay.add(jsQuote2);
        jsQuote2.setBounds(100, 480, 210, 2);

        jlClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/images/close.png"))); // NOI18N
        jlClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCloseMouseClicked(evt);
            }
        });
        jpDisplay.add(jlClose);
        jlClose.setBounds(360, 10, 32, 32);

        getContentPane().add(jpDisplay);
        jpDisplay.setBounds(400, 0, 400, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jlCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCloseMouseClicked
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new WindowEvent(this,WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_jlCloseMouseClicked

    private void jbLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLoginMouseEntered
        jbLogin.setForeground(Color.white);
    }//GEN-LAST:event_jbLoginMouseEntered

    private void jbLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLoginMouseExited
        jbLogin.setForeground(new Color(236, 240, 241));
    }//GEN-LAST:event_jbLoginMouseExited

    private void jtfPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPasswordActionPerformed
        processLogin();
    }//GEN-LAST:event_jtfPasswordActionPerformed

    private void jtfPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPasswordFocusGained
        if(jtfPassword.getText().equals(PASSWORD_TEXT_FIELD_PLACEHOLDER))
            jtfPassword.setText("");
    }//GEN-LAST:event_jtfPasswordFocusGained

    private void jtfPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfPasswordFocusLost
        if(jtfPassword.getText().length() == 0)
            jtfPassword.setText(PASSWORD_TEXT_FIELD_PLACEHOLDER);
    }//GEN-LAST:event_jtfPasswordFocusLost

    private void jtfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfEmailKeyTyped

    }//GEN-LAST:event_jtfEmailKeyTyped

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        processLogin();
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost
        if(jtfEmail.getText().length() == 0)
        jtfEmail.setText(EMAIL_TEXT_FIELD_PLACEHOLDER);
    }//GEN-LAST:event_jtfEmailFocusLost

    private void jtfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusGained
        if(jtfEmail.getText().equals(EMAIL_TEXT_FIELD_PLACEHOLDER))
        jtfEmail.setText("");
    }//GEN-LAST:event_jtfEmailFocusGained

    private void jbLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLogin1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLogin1MouseExited

    private void jbLogin1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLogin1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLogin1MouseEntered

    private void jbLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLogin1ActionPerformed
        // TODO add your handling code here:
        processLogin();
    }//GEN-LAST:event_jbLogin1ActionPerformed

    private void jbSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSignUpActionPerformed
        // TODO add your handling code here:
        close();
        jfRegistration.setVisible(true);
    }//GEN-LAST:event_jbSignUpActionPerformed
 
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
                if ("Macintosh".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    private class LoadingTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            closeLoading();
        }
    }
    private void closeLoading() {
        this.jfLoading.setVisible(true);
        this.jfLoading.setLocationRelativeTo(null);       
        WindowEvent we = new WindowEvent(jfLoading,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
        this.jfLoading.setVisible(false);
        javafx.application.Application.launch(App.class);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbLogin;
    private javax.swing.JButton jbLogin1;
    private javax.swing.JLabel jlAnimation;
    private javax.swing.JLabel jlClose;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlQuote;
    private javax.swing.JLabel jlSignIn;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JPanel jpDisplay;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JSeparator jsEmail;
    private javax.swing.JSeparator jsPassword;
    private javax.swing.JSeparator jsQuote;
    private javax.swing.JSeparator jsQuote2;
    private javax.swing.JSeparator jsTitle;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JPasswordField jtfPassword;
    // End of variables declaration//GEN-END:variables
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private Loading jfLoading;
    private registration jfRegistration;
    private Timer timer;
}
