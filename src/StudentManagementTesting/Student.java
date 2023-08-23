/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagementTesting;

import java.io.Serializable;

/**
 *
 * @author duyvu
 */
public class Student implements Serializable {

    String name;
    Integer age;

    // Default Constructor
    public Student() {
    }

    // Parameterized Constructor
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    public String getLineFormatted() {
//        return this.name + "," + this.age;
//    }
    @Override
    public String toString() {
        return this.name + "," + this.age;
    }

    public static String getFileHeaderFormat() {
        return "Fullname, Age";
    }

}
