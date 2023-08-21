/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileTesting;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author duyvu
 */
public class FileClassTesting {

    public static void main(String[] args) throws IOException {

        // File
        File f1 = new File("tmp/COPYRIGHT.txt");
        System.out.println("Name: " + f1.getName());
        System.out.println("Path: " + f1.getPath());
        System.out.println("Parent: " + f1.getParent());
        System.out.println("Exists: " + f1.exists());
        System.out.println("IsDirectory: " + f1.isDirectory());
        System.out.println("IsFile: " + f1.isFile());
        System.out.println("size: " + f1.length());

        if (f1.createNewFile()) {
            System.out.println("File created: " + f1.getAbsolutePath());
        } else {
            System.out.println("File Already Exists!");
        }

    }
}
