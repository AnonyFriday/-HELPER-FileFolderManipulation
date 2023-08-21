/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIElement;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

/**
 * JPanel
 * - The Intermediate containers are used to structure the graphic application
 *
 * @author duyvu
 */
public class IntermediateComponents {

    public static void main(String[] args) {

        // JFrame (Top Level Container)
        JFrame jFrame = new JFrame("GUI COURSE");
        jFrame.setLayout(null);
        jFrame.setBounds(100, 100, 1000, 1000);
        jFrame.setVisible(true);

        // JPanel (Intermediate Component)
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.red);
        jPanel.setBounds(100, 100, 1000, 1000);
        jPanel.setVisible(true);

        // JScrollPane (Intermediate Component)
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(100, 100, 1000, 1000);
        scrollPane.add(jPanel);

        // JSplitPane
        Panel p1 = new Panel();
        p1.setBackground(Color.CYAN);
        p1.setBounds(100, 100, 1000, 1000);

        Panel p2 = new Panel();
        p2.setBackground(Color.GREEN);
        p2.setBounds(300, 100, 1000, 1000);

//        jFrame.setLayout(new GridLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);

        // JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(50, 50, 200, 200);

        JPanel pTab1 = new JPanel();
        pTab1.setBackground(Color.red);

        JPanel pTab2 = new JPanel();
        pTab2.setBackground(Color.BLACK);

        JPanel pTab3 = new JPanel();
        pTab3.setBackground(Color.BLUE);

        tabbedPane.add("Main", pTab1);
        tabbedPane.add("Sales", pTab2);
        tabbedPane.add("Contact Us", pTab3);

        // JToolBar
        JToolBar jToolBar = new JToolBar();
        jToolBar.addSeparator();
        jToolBar.setBounds(0, 0, 500, 50);
//        jToolBar.setRol

        JButton jButton1 = new JButton("File");
        JButton jButton2 = new JButton("Control");
        JButton jButton3 = new JButton("Chat");

        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);

        // Adding Components to the JFrame
//        jFrame.add(jPanel);
//        jFrame.add(scrollPane);
//        jFrame.add(splitPane);
//        jFrame.add(tabbedPane);
        jFrame.add(jToolBar);
    }
}
