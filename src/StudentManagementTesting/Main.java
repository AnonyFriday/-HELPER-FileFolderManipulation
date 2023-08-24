/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementTesting;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author duyvu
 */
public class Main {

    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();
        studentList.add(new Student("Vu", 12));
        studentList.add(new Student("Kim", 22));
        studentList.add(new Student("Duy", 32));

        // ===== Save Array Of Student on files ====
        // Create file
        File fileTextToExport = new File("tmp/files/fileTextToExport.txt");
        File fileBinaryToExport = new File("tmp/files/fileBinaryToExport.dat ");
        File fileTextBufferToRead = new File("tmp/files/fileTextBufferTest.txt");

        // Write text-based to file
        // - .txt
        FileDAO.writeStudentsToFileTextBased(fileTextToExport, studentList, false);

        // Write binary to file
        // - .dat
        FileDAO.writeStudentsToFileBinary(fileBinaryToExport, studentList);

        // ===== Read Data from files ====
        // Read binary file
        List<Student> students = FileDAO.readStudentsFromFileBinary(fileBinaryToExport);
        students.forEach((student) -> {
            System.out.println(student.toString());
        });

        // Read text file
        List<Student> students2 = FileDAO.readStudentsFromFileTextBased(fileTextToExport);
        students2.forEach((student) -> {
            System.out.println(student.toString());
        });

        // Read text file on buffer
        FileDAO.readStudentsFromFileTextBasedBuffered(fileTextBufferToRead);
    }
}
