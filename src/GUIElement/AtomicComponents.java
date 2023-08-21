/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIElement;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Atomic Component (Unique entity)
 * - button, Jlabel, checkbox, radio
 * - combo box
 * - list, menu
 * - textfield, textarea, labe1
 * - FileChooser, ColorChooser
 * - ...
 *
 * @author duyvu
 */
public class AtomicComponents {

    public static void main(String[] args) {
        // JFrame (Top Level Container)
        JFrame jFrame = new JFrame("GUI COURSE");
        jFrame.setLayout(new FlowLayout());
        jFrame.setBounds(100, 100, 1000, 1000);
        jFrame.setVisible(true);
//        jFrame.getContentPane().setBackground(Color.black);

        // =================== Button ==========================
        JButton b1 = new JButton("Click Me");
        b1.setBounds(50, 50, 100, 30);

        // Button's Event Handling
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.getContentPane().setBackground(Color.BLUE);
            }
        });

        // =================== JLabel ==========================
        JLabel jLabel = new JLabel("My Label. Rate Us 5 stars");
        JButton b2 = new JButton("Change Label");
        b2.setBounds(150, 50, 200, 30);
        jLabel.setBounds(150, 50, 200, 50);

        // Event Handling for changing text on label
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabel.setText("Changed");
            }
        });

        // =================== JTextField ==========================
        JTextField textfield = new JTextField();
        JButton b3 = new JButton("Get Text Now");

        textfield.setBounds(100, 100, 500, 50);
        textfield.setBackground(Color.BLACK);

        // Getting data from textField
        String s1 = textfield.getText();

        // =================== ComboBox ==========================
        String[] lists = {"Java", "C++", "Python", "Kotlin", "Android"};
        JComboBox cb = new JComboBox(lists);
        cb.setBounds(50, 50, 90, 20);
        jFrame.setLayout(null);

        // ComboBox's Event Handling
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Getting the selected item
                String s = (String) cb.getSelectedItem();

                // Selecting the case
                System.out.println(s + " is selected");
            }
        });

        // =================== JList ==========================
        // =================== JSlider ==========================
        // -allows a graphic entry of a number (a value)
        // -a user can select a value from a specific range
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);
        jFrame.setLayout(new FlowLayout());

        // Adding Functionality to JSlider
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // getting the selected value from slider
                int value = slider.getValue();
                System.out.println("Value of slider: " + value);
            }
        });

        // =================== JRadionButton ==========================
        // -Choose one option from multiple options
        // -Should be added in ButtonGroup to select one radio button only
        // -Wirely used in exam systems or quiz
        JRadioButton radio1 = new JRadioButton("Java");
        JRadioButton radio2 = new JRadioButton("C++");
        JRadioButton radio3 = new JRadioButton("Python");
        JRadioButton radio4 = new JRadioButton("Android");

        // Adding radio buttons to the group
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        buttonGroup.add(radio3);
        buttonGroup.add(radio4);

        // Radion1 action listener
        radio1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Execute thiscode when radio2 is selected
                System.out.println("Radion is selected");
            }
        });

        // =================== JTextArea ==========================
        // -multi line region that display text
        // -it allows the editing of multiple line text
        // -displays text
        JTextArea jTextArea = new JTextArea("Welcome to Master Coding");
        jTextArea.setBounds(10, 30, 200, 200);

        JButton jButton = new JButton("Get Text from Area");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String k = jTextArea.getText();
                System.out.println(k);
            }

        });

        jFrame.setLayout(null);

        // =================== JMenuBar ==========================
        // MenuBar
        JMenuBar jMenuBar = new JMenuBar();

        // Menu
        JMenu menu = new JMenu("File");

        // Items
        JMenuItem item1 = new JMenuItem("Load");
        JMenuItem item2 = new JMenuItem("Save");
        JMenuItem item3 = new JMenuItem("Edit");

        menu.add(item1);
        menu.add(item2);
        menu.add(item3);

        for (Component el : menu.getMenuComponents()) {
            if (el instanceof JMenuItem) {
                ((JMenuItem) el).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(el);
                    }
                });
            }
        }

        jMenuBar.add(menu);

        // =================== JTable and DefaultOptionModel ==========================
        // -display data in tabular form
        // -composed of rows and columns
        // -Columns: Name of columns
        // -Data: 2D array of data
        // -Always come with the ScrollViewPane
        String[] columns = {"ID", "Name", "Salary"};
        String[][] data = {
            {"1", "Ali1", "1700"},
            {"2", "Ali2", "17000"},
            {"3", "Ali3", "170000"},
            {"4", "Ali4", "1700000"}
        };
        JTable jTable = new JTable(data, columns);
        ListSelectionModel select = jTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String data = null;

                int[] row = jTable.getSelectedRows();
                int[] column = jTable.getSelectedColumns();

                for (int i = 0; i < row.length; i++) {
                    for (int j = 0; j < row.length; j++) {
                        data = (String) jTable.getValueAt(row[i], column[i]);
                    }
                }

                System.out.println("Table element selected at: " + data);
            }
        });

        jFrame.setLayout(new FlowLayout());

        // Adding Atomic Component into Top-Level Component
//        jFrame.add(b1);
//        jFrame.add(jLabel);
//        jFrame.add(b2);
//        jFrame.add(textfield);
//        jFrame.add(cb);
//        jFrame.add(slider);
//        jFrame.add(radio1);
//        jFrame.add(radio2);
//        jFrame.add(radio3);
//        jFrame.add(radio4);
//        jFrame.add(jTextArea);
//        jFrame.add(jButton);
        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jTable);

    }
}
