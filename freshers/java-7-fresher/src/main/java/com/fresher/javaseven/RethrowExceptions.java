package com.fresher.javaseven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * 2. Multiple exception handling
 * 3. Try with resources
 * 4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * +++ 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class RethrowExceptions {
    public static void main(String[] args) throws Exception {
        // before java 7 it was only possible to write the class "Exception"
        // even though you would throw more than one exception (not at once)
        //before();
        after();
    }

    private static void before() throws Exception { // ide nowadays also warns you, sonarlint plugin rocks!
        try {
            String[] strings = new String[1];
            strings[0] = "Hello";
           // strings[1] = "World?"; // this will throw index out of bounds exception for sure.

            // and this will throw a file not found exception
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            reader.close();
        } catch (Exception e) {
            throw e;
        }
    }

    private static void after() throws IOException, IndexOutOfBoundsException {
        try {
            String[] strings = new String[1];
            strings[0] = "Hello";
            strings[1] = "World?"; // this will throw index out of bounds exception for sure.

            // and this will throw a file not found exception
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            reader.close();
        } catch (Exception e) {
            throw e;
        }
    }

}
