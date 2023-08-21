/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MapTesting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * The difference between TreeMap and HashMap
 *
 * @author duyvu
 */
public class HashTreeSortedMap {

    public static void main(String[] args) {

        // HashMap
        // A collection that 
        // Stores any type of data
        // Store keys randomly
        // Faster than treemap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Abbr", 1111);
        hashMap.put("Bbr", 3333);
        hashMap.put("Sbr", 2222);
        hashMap.put("Nbbr", 0000);
        hashMap.put("Dbbr", 9999);
        hashMap.put("Cbbr", 8888);
        hashMap.put("Cbbr", 000000);

        System.out.println("Hash Map: " + hashMap);

        // TreeMap
        // - Key Value pairs
        // - Store only comparable data
        // - Store keys in sorted order
        // - Slower than HashMap
        // - Using Tree data structure
        Map<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareToIgnoreCase(o1);
            }
        });
        treeMap.put("Abbr", 1111);
        treeMap.put("abbr", 0000000000);
        treeMap.put("Bbr", 3333);
        treeMap.put("Sbr", 2222);
        treeMap.put("Nbbr", 0000);
        treeMap.put("Dbbr", 9999);
        treeMap.put("Cbbr", 8888);
        treeMap.put("CbbrD", 100888);

        System.out.println("Tree Map: " + treeMap);
    }
}
