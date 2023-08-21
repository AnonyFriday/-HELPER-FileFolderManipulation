/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIElement;

import com.sun.tools.javac.Main;
import javax.swing.JFrame;

/**
 * JFrame
 * - is top-level component that includes all other components
 *
 * @author duyvu
 */
public class JFrameTesting extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("First GUI FRAME");
        jFrame.setBounds(0, 200, 1000, 1000);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
