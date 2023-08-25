/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CompressionTesting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 *
 * @author duyvu
 */
public class CompressionDAO {

    // Write text-based to the file
    public static <T> void writeFile(File file, T data, boolean isAppend) {
        try (PrintWriter writer = new PrintWriter(file); BufferedWriter bw = new BufferedWriter(writer, 8)) {

            // Write data object to the file
            bw.write(data.toString());

        } catch (FileNotFoundException ex) {
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex1) {
                    Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Reading Text-Based File
    public static String readFile(File file) {
        String data = null;
        try (Reader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {
            data = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    // Compress Data Using Deflater
    public static byte[] compressFile(File file) {

        byte[] compressedData = null;

        try {
            // Retrive Data for compression
            String data = readFile(file);
            compressedData = new byte[512];

            System.out.println("Data Before Compression: " + data);
            System.out.println("Length Before Compression: " + data.length());

            // Compress data
            Deflater deflater = new Deflater();
            deflater.setInput(data.getBytes("UTF-8"));

            // Finish the deflater
            // - Does not flush the deflater
            // - No more input will be provided
            // - Setting a flag indicating that it is finished compressing data
            deflater.finish();

            // Checking the Post Data Compression
            int compressedDataLength = deflater.deflate(compressedData);
            System.out.println("Data Before Decompression: " + new String(compressedData, "UTF-8"));
            System.out.println("Length After Compression: " + compressedDataLength);

            // End the deflater
            // - freeup resources
            deflater.end();

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compressedData;
    }

    public static void decompressFile(byte[] compressedData) {
        try {
            // Precheck data before decompression
            System.out.println("Data Before Decompression: " + new String(compressedData, "UTF-8"));
            System.out.println("Length Before Decompression: " + new String(compressedData, "UTf-8").length());

            Inflater inflater = new Inflater();

            // Set input for decompression
            inflater.setInput(compressedData);
            inflater.finished();

            // Uncompress the data
            byte[] decompressedData = new byte[512];
            int decompressedDataLength = inflater.inflate(decompressedData);
            inflater.end();

            // Checking the Post Data Decompression
            System.out.println("Data After Decompression: " + new String(decompressedData, "UTF-8"));
            System.out.println("Length After Decompression: " + decompressedDataLength);

        } catch (DataFormatException ex) {
            Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CompressionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
