/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileTesting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author duyvu
 */
public class FileManipulationTesting extends FileDAO {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        // ======================= FileOutput ====================
        // FileOutputStream
        FileDAO.writeSingleDataBinaryFile(new File("tmp/singlebinaryString.dat"), "Hello World There");

        // FileOutputStream
        FileDAO.writeSingleDataBinaryFile(new File("tmp/singlebinaryNumber.dat"), String.valueOf(12));

        // FileOutputStream + ObjectOutputStream
        ArrayList<Employee> list = new ArrayList<>() {
            {
                add(new Employee("VU KIM", 12));
                add(new Employee("DUY", 20));
                add(new Employee("TRINH", 33));
            }
        };
        FileDAO.writeArrayDataBinaryFile(new File("tmp/arraybinary.dat"), list);

        // ======================= FileInput ====================
//        FileDAO.readSingleDataBinaryFile(new File("tmp/singlebinaryString.dat"));
//        FileDAO.readSingleDataBinaryFile(new File("tmp/singlebinaryNumber.dat"));
//        FileDAO.readSingleDataBinaryFile(new File("tmp/arraybinary.dat"));
//        FileDAO.readArrayDataBinaryFile(new File("tmp/arraybinary.dat"));

        // ======================= Writer ====================
        FileDAO.writeDataTextBasedFile(new File("tmp/singleStringTextBased.txt"), "VU KIM DUY");
        
        ArrayList<Employee> list2 = new ArrayList<>() {
            {
                add(new Employee("VU KIM", 12));
                add(new Employee("DUY", 20));
                add(new Employee("TRINH", 33));
            }
        };
        FileDAO.writeArrayDataTextBasedFile(new File("tmp/arrayTextBased.txt"), list2);
        // ======================= Reader ====================
        FileDAO.readArrayDataTextBasedFile(new File("tmp/arrayTextBased.txt"));
    }
}
