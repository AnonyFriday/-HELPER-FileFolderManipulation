/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Generic;

/**
 * Generic
 * - Referring to all of the Primitive Datatype
 *
 *
 * Standard Type (Coding convention)
 * - T: Type
 * - E: Element
 * - N: Number
 * - K: Key
 * - V: Value
 * - S,U,V etc. -2nd, 3rd, 4th types
 *
 * @author duyvu
 *
 * Code Re-usability
 *
 * Type Safety
 * - Cannot assign crossing primitive data type each others
 * - will get a compile-time error "Type mismatch: cannot convert from boolean to String"
 */
// Generic Class
// - Using Object as the General Primitive Datatype will force to casting whenever using its function
// - shorten the lengthy type casting
class GenericClass<T> {

//    Object obj;
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}

// Generic Interface
interface GenericInterface<T> {

    public void PrintMsg(T t);
}


// Wild Card - Joker
// - If B is a subtype of A, List<B> is not a subtype of List<A>

public class GenericTesting {

    // Generic Method
    public static <T> void Welcome(T t) {
        System.out.println("Welcom to " + t);
    }

    public static void main(String[] args) {

        // Generic Class
        GenericClass<String> ge = new GenericClass<>();
        ge.setObj("Chimney");
        System.out.println(ge.getObj());

        // Generic Method
        Welcome("Chim");

    }
}
