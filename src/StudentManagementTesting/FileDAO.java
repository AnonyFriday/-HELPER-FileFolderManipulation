/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementTesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duyvu
 */
public abstract class FileDAO {

    // Store Students on the Text-based File
    // - Store Student with the format: [Name], [Age]
    public static void writeStudentsToFileTextBased(File file, List<? extends Student> list, boolean isAppend) {

        // Create the file stream and write a new
        try (OutputStream outputStream = new FileOutputStream(file, isAppend)) {

            // Import the file header format
            outputStream.write((Student.getFileHeaderFormat() + "\n").getBytes());

            // Export data to the file
            for (Student obj : list) {
                String line = obj.toString() + "\n";
                outputStream.write(line.getBytes());
            }

        } catch (FileNotFoundException ex) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex1) {
                    Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Store Students on the Binary File
    public static void writeStudentsToFileBinary(File file, List<? extends Student> list) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException ex) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex1) {
                    Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Read Students on the Binary File
    public static <T> List<T> readStudentsFromFileBinary(File file) {

        List<T> list = null;

        // Readingh Binary File annd return the list of object
        try (FileInputStream fileInputStream = new FileInputStream(file); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            list = (List<T>) objectInputStream.readObject();

        } catch (FileNotFoundException ex) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex1) {
                    Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    // Read Studens on the Text File
    public static LinkedList<Student> readStudentsFromFileTextBased(File file) {

        List<Student> list = new LinkedList<Student>();

        try (Reader reader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(reader)) {

            // Ignore the first row (header column)
            bufferedReader.readLine();

            // Import each row and extract each value based on the row formatted line
            // - ready(): the buffer is not empty or the main stream is ready
            while (bufferedReader.ready()) {
                String[] dataLine = bufferedReader.readLine().split(",");

                // index 0: Name
                // index 1: Age
                list.add(new Student(dataLine[0], Integer.parseInt(dataLine[1])));

            };
        } catch (IOException ex) {
            Logger.getLogger(FileDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (LinkedList<Student>) list;
    }

}
