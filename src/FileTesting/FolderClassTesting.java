/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileTesting;

import java.io.File;
import java.io.IOException;

/**
 * Directory
 * - is a file that contains a list of other files and dir.
 *
 * @author duyvu
 */
public class FolderClassTesting {

    public static void main(String[] args) throws IOException {

        // Create the directory named Java Coding
        File directory1 = new File("Java Coding");
        directory1.mkdir();

        System.out.println("Created: " + directory1.getAbsolutePath());

        // Get All files in the directory
        if (directory1.isDirectory()) {
            System.out.println("Directory of: " + directory1.getName());

            // List all files
            String[] files = directory1.list();

            for (int i = 0; i < files.length; i++) {
                File f = new File(directory1 + "/" + files[i]);

                if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getCanonicalPath());
                } else {
                    System.out.println("File: " + f.getAbsolutePath());
                }

            }
        } else {
            System.out.println("Not a directory");
        }
    }

}
