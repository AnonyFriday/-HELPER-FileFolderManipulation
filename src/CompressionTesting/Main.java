/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompressionTesting;

import java.io.File;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {
        // Create Files
        File file = new File("tmp/files/fileCompressionTesting.txt");
        String name = "abcab2ecn23nc23,./l;;23😀😀😀😀😀😀😀😀";

        int age = 90;
        Student student = new Student(name, age); // Write data to the file
        CompressionDAO.writeFile(file, student, true);

        // Compressing File
        byte[] compressedData = CompressionDAO.compressFile(file);

        // DecompressData
        System.out.println("\n\n");
        CompressionDAO.decompressFile(compressedData);
    }
}
