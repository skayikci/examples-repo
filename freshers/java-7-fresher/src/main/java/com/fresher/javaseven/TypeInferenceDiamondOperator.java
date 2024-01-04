package com.fresher.javaseven;

import java.util.ArrayList;
import java.util.List;

/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * 2. Multiple exception handling
 * 3. Try with resources
 * 4. Enhanced For loop
 * +++5. Type inference
 * +++6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class TypeInferenceDiamondOperator {
    public static void main(String[] args) {
        // before java 7, you could only write generic types like this:
        List<String> strings = new ArrayList<String>();
        strings.add("Accounting");
        strings.add("IT");
        strings.add("HR");
        strings.add("Hi");

        // after java 7, you can also write it like this, as long as the compiler can infer the type:
        List<String> stringsInferred = new ArrayList<>();
        stringsInferred.add("Accounting");
        stringsInferred.add("IT");
        stringsInferred.add("HR");
        stringsInferred.add("Hi");
    }
}
