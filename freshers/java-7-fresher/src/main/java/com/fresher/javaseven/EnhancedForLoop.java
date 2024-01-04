package com.fresher.javaseven;

import java.util.ArrayList;
import java.util.List;

/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * 2. Multiple exception handling
 * 3. Try with resources
 * +++4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class EnhancedForLoop {
    public static void main(String[] args) {
        // before java 7, you could only write for statements like this:
        List<String> strings = new ArrayList<String>();
        strings.add("Accounting");
        strings.add("IT");
        strings.add("HR");
        strings.add("Hi");

        for (int i = 0; i < strings.size(); i++) {
            System.out.println("Value: " + strings.get(i));
        }

        // not it is possible to iterate over a list or an array in for-each manner:
        // see how clean and index-free it is?
        for (String value : strings) {
            System.out.println("Value: " + value);
        }
    }
}
