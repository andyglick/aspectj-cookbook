package com.oreilly.aspectjcookbook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginScreen extends JDialog
{
   private boolean cancelled = false;
   private JTextField usernameTextField;
   private JPasswordField passwordField;
   
   public LoginScreen()
   {
      super(new JFrame(), true);
      setupGui();
   }
   
   private void setupGui()
   {
      JPanel loginPanel = new JPanel();
      loginPanel.setLayout(new GridLayout(3,2));
      
      JLabel usernameLabel = new JLabel("Username:");
      this.usernameTextField = new JTextField();
      
      JLabel passwordLabel = new JLabel("Password:");
      this.passwordField = new JPasswordField();
      passwordField.setEchoChar('*');
      
      JButton okButton = new JButton("Ok");
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae)
         {
            okClicked();
         }
      });
      
      JButton cancelButton = new JButton("Cancel");
      cancelButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae)
         {
            cancelClicked();
         }
      });
      
      loginPanel.add(usernameLabel);
      loginPanel.add(usernameTextField);
      loginPanel.add(passwordLabel);
      loginPanel.add(passwordField);
      loginPanel.add(okButton);
      loginPanel.add(cancelButton);
      this.getContentPane().add(loginPanel);
      
      this.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent we)
         {
            // Do nothing, the user should click one of the available buttons.
         }
      });
      
      this.setBounds(10,10,200,100);
   }
   
   private void okClicked()
   {
      this.setVisible(false);
      this.cancelled = false;
   }
   
   private void cancelClicked()
   {
      this.setVisible(false);
      this.cancelled = true;
   }
   
   public void reset()
   {
      this.usernameTextField.setText("");
      this.passwordField.setText("");
   }
   
   public boolean cancelled()
   {
      return this.cancelled;
   }
   
   public String getUsername()
   {
      return this.usernameTextField.getText();
   }
   
   public char[] getPassword()
   {
      return this.passwordField.getPassword();
   }
}
