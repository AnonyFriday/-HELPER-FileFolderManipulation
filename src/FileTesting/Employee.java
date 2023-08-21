/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FileTesting;

import java.io.Serializable;

/**
 *
 * @author duyvu
 */
public class Employee implements Serializable {

    String name;
    Integer salary;

    public Employee() {
    }

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.salary;
    }

}
