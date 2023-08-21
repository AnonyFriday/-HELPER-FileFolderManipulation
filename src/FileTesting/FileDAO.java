/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileTesting;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author duyvu
 */
public abstract class FileDAO {

    // ======================= FileOutput ====================
    // FileOuputStream
    public static void writeSingleDataBinaryFile(File file, String obj) throws FileNotFoundException, IOException {
        // Using OutputFileStream Directly 
        // - Output from CODE -> DATASOURCE (file)
        // - Converting data (a string) into array of bytes
        // - Write those bytes into file
        OutputStream outputStream = new FileOutputStream(file);

        // Converts the string into bytes
        byte[] dataBytes = obj.getBytes();
        // writes databytes to the output stream
        outputStream.write(dataBytes);

        // Close output stream
        outputStream.close();
    }

    // FileOutputStream + ObjectOutputStream
    public static void writeArrayDataBinaryFile(File file, List<? extends Employee> emps) throws FileNotFoundException, IOException {

        // Create and access the file
        // - Create FileOutputStream (a stream)
        OutputStream fileStream = new FileOutputStream(file);

        // Convert Object into bytes into serial binary representation
        // - Take each Object, take each field of each Object and converting into binary
        // - Adding converted Object into ObjectOutputStream (a stream)
        // - Convert entire binary steam in OOS to FOS (automatically)
        ObjectOutputStream binaryObjectStream = new ObjectOutputStream(fileStream);
        binaryObjectStream.writeObject(emps);

        // Close all streams
        fileStream.close();
        binaryObjectStream.close();
    }

    // ======================= FileInput ====================
    // FileInputStream
    // - Read single byte ordinally from a file
    public static void readSingleDataBinaryFile(File file) throws IOException {

        FileInputStream fileStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileStream.read(data);

        for (byte aByte : data) {
            System.out.print((char) aByte);
        }

        // Close all streams
        fileStream.close();
    }

    // FileInputStream + ObjectInputStream
    // - Read byte and passed to the binary stream in a file
    public static void readArrayDataBinaryFile(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileStream);

        ArrayList<Employee> list = (ArrayList<Employee>) objectInputStream.readObject();

        for (Employee emp : list) {
            System.out.println(emp.toString());
        }

        // Closing Objects
        fileStream.close();
        objectInputStream.close();
    }

    // ======================= Writer ====================
    // PrintWriter
    // - Text-based character
    // - Alternative is FileWriter but writing single character, which is obfuscate
    // - Append each character to the PrintWriter buffer
    // - Text-based data will be added into a file
    // - Always add EOF at the end of file to denote the end of string
    public static void writeDataTextBasedFile(File file, String obj) throws FileNotFoundException {
        Writer writer = new PrintWriter(file);

        // Passing each character of the string to each block of buffer in PrintWriter
        ((PrintWriter) writer).println(obj);
        ((PrintWriter) writer).printf("With the format: %s\n", obj);
        ((PrintWriter) writer).append("New appeneded text");

        // Empty the content of the PrintWriter object
        ((PrintWriter) writer).flush();

        // Closing Objects
        ((PrintWriter) writer).close();
    }

    public static void writeArrayDataTextBasedFile(File file, List<? extends Employee> emps) throws FileNotFoundException {
        Writer writer = new PrintWriter(file);

        for (Employee emp : emps) {
            ((PrintWriter) writer).println(emp.toString());
        }

        // Empty the content of the PrintWriter object
        ((PrintWriter) writer).flush();

        // Closing Objects
        ((PrintWriter) writer).close();
    }

    // ======================= Reader ====================
    // FileReader + BuferredReader
    // - FileReader only read a character or an array of characters
    // - Apply a layer of bufferedReader provides a defined buffer reading 
    // (e.g. read 1 line until reaching escape character)
    // - When using BufferedReader, you need to know the format of the file before reading
    public static void readArrayDataTextBasedFile(File file) throws FileNotFoundException, IOException {
        Reader reader = new FileReader(file);
        Reader bufferReader = new BufferedReader(reader);

        // Create the pattern matcher to match the 
        String patternString = "(?<name>\\D+)\\s+(?<salary>\\d+)";
        Pattern pattern = Pattern.compile(patternString);

        while (bufferReader.ready()) {

            // Extract a line using bufferreader
            String line = ((BufferedReader) bufferReader).readLine();
            Matcher matcher = pattern.matcher(line);
            // Extract each property of the line after acknowledging the format
            // Format: name + " " + salary

            if (matcher.matches()) {
                String name = matcher.group("name");
                Integer salary = Integer.parseInt(matcher.group("salary"));

                Employee emp = new Employee(name, salary);
                System.out.println(emp.toString());
            }
        }
    }
}
