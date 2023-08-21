/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIProjects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author duyvu
 */
public class WordCounter {

    public static void main(String[] args) {

        // Top Level Container
        JFrame jFrame = new JFrame("Word Counter");
        jFrame.setBounds(100, 100, 800, 800);
        jFrame.setVisible(true);

        // Text Area
        JTextArea jTextArea = new JTextArea();
        jTextArea.setBounds(50, 50, 300, 300);

        // Button
        JButton jButton = new JButton();
        jButton.setText("Check Words");
        jButton.setBounds(100, 400, 150, 50);

        // Event Handling
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textContent = jTextArea.getText();

                if (!textContent.isEmpty()) {
                    String[] words = textContent.split("\\s+");
                    JOptionPane.showMessageDialog(jFrame, words.length);
                }
            }
        });

        // Adding Components to Frame
        jFrame.add(jTextArea);
        jFrame.add(jButton);
        jFrame.setLayout(null);
    }
}
