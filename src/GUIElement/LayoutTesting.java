/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIElement;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author duyvu
 */
public class LayoutTesting {
    
    public static void main(String[] args) {
        // JFrame (Top Level Container)
        JFrame jFrame = new JFrame("GUI COURSE");
        jFrame.setLayout(new FlowLayout());
        jFrame.setBounds(100, 100, 1000, 1000);
        jFrame.setVisible(true);

        // ============ Border Layout ==========================
        // - BorderLayout is used to arrange the component in 5 regions: north, south, east, west and center
//        JButton b1 = new JButton("North");
//        JButton b2 = new JButton("West");
//        JButton b3 = new JButton("East");
//        JButton b4 = new JButton("South");
//        JButton b5 = new JButton("Center");
//
//        jFrame.setLayout(new BorderLayout(20, 15));
//        jFrame.add(b1, BorderLayout.NORTH);
//        jFrame.add(b2, BorderLayout.WEST);
//        jFrame.add(b3, BorderLayout.EAST);
//        jFrame.add(b4, BorderLayout.SOUTH);
//        jFrame.add(b5, BorderLayout.CENTER);
        // ============ Grid Layout ==========================
        // - Arrrange in a regular grid
//        JButton b1 = new JButton("1");
//        JButton b2 = new JButton("2");
//        JButton b3 = new JButton("3");
//        JButton b4 = new JButton("4");
//        JButton b5 = new JButton("5");
//        JButton b6 = new JButton("6");
//        JButton b7 = new JButton("7");
//        JButton b8 = new JButton("8");
//        JButton b9 = new JButton("9");
//
//        jFrame.add(b1);
//        jFrame.add(b2);
//        jFrame.add(b3);
//        jFrame.add(b4);
//        jFrame.add(b5);
//        jFrame.add(b6);
//        jFrame.add(b7);
//        jFrame.add(b8);
//        jFrame.add(b9);
//
//        jFrame.setLayout(new GridLayout(3, 3, 30, 30));
        // ============ Flow Layout ==========================
        // - Arrange elements in the flow
        // - Default Flowing behaviors
//        JButton b1 = new JButton("1");
//        JButton b2 = new JButton("2");
//        JButton b3 = new JButton("3");
//        JButton b4 = new JButton("4");
//        JButton b5 = new JButton("5");
//        JButton b6 = new JButton("6");
//        JButton b7 = new JButton("7");
//        JButton b8 = new JButton("8");
//        JButton b9 = new JButton("9");
//        
//        jFrame.add(b1);
//        jFrame.add(b2);
//        jFrame.add(b3);
//        jFrame.add(b4);
//        jFrame.add(b5);
//        jFrame.add(b6);
//        jFrame.add(b7);
//        jFrame.add(b8);
//        jFrame.add(b9);
//        
//        jFrame.setLayout(new FlowLayout(FlowLayout.TRAILING));
        // ============ Box Layout ==========================
        // - Arrange the components either vertically or horizontally
        // - provides 4 constants
        // public static final int X_AXIS
        // public static final int Y_AXIS
        // public static final int LINE_AXIS
        // public static final int PAGE_AXIS
//        Button[] buttons = new Button[5];
//        for (int i = 0; i < 5; i++) {
//            buttons[i] = new Button("Button" + (i + 1));
//            jFrame.add(buttons[i]);
//        }
        // Placing the buttons in horizontal way
//        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.X_AXIS));
//        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
//        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.LINE_AXIS));
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.PAGE_AXIS));

        // ============ Card Layout ==========================
        // - only 1 component is visible at a time
        // - treat each component as a card
        Button[] buttons = new Button[5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button("Button" + (i + 1));
            jFrame.add(buttons[i]);
        }
        jFrame.setLayout(new CardLayout(40, 30));
    }
}
