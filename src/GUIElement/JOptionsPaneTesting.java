/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIElement;

import javax.swing.JOptionPane;

/**
 * AWT & SWING
 * - AWT: Abstract Windonw Toolkit
 * - Swing:
 *
 * @author duyvu
 */
/*
 * JOptionPane
 * 1- Input Dialog
 * 2- Message Dialog
 */
public class JOptionsPaneTesting {
    
    public static void main(String[] args) {

        // Obtain user input from JOptionPane input dialogs
        String firstNumber = JOptionPane.showInputDialog("Enter first Integer");
        String secondNumber = JOptionPane.showInputDialog("Enter second Integer");

        // Convert string inputs to int value for use in calculation
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        
        int sum = number1 + number2;

        // Display result in a JOptionPane message Dialog
        JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of two Integers", JOptionPane.ERROR_MESSAGE);
        
    }
}
