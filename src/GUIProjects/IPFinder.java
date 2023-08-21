/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIProjects;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author duyvu
 */
public class IPFinder {

    public static void main(String[] args) {

        // JFrame
        JFrame jFrame = new JFrame("IP Finder Program");
        jFrame.setBounds(100, 100, 1000, 200);
        jFrame.setVisible(true);

        // Label
        JLabel label = new JLabel("Ip Finder Program");
        label.setBounds(50, 70, 150, 20);

        // Text Field
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 20);

        // Button
        JButton button = new JButton("Find IP");
        button.setBounds(50, 150, 80, 30);

        // Event Handling
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = textField.getText();
                try {
                    InetAddress ia = InetAddress.getByName(url);
                    String ip = ia.getHostAddress();
                    String host = ia.getHostName();

                    JOptionPane.showMessageDialog(jFrame, "IP Address: " + ip);
                    JOptionPane.showMessageDialog(jFrame, "IP Host: " + host);

                } catch (UnknownHostException ex) {
                    Logger.getLogger(IPFinder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Adding Elements
        jFrame.add(label);
        jFrame.add(textField);
        jFrame.add(button);

        jFrame.setLayout(new GridLayout());
    }
}
