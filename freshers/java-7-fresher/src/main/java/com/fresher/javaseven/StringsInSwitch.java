package com.fresher.javaseven;

import java.util.ArrayList;
import java.util.List;

/**
 * The most famous new features are as follows:
 * +++1. Strings in switch
 * 2. Multiple exception handling
 * 3. Try with resources
 * 4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class StringsInSwitch {

    public static void main(String[] args) {
        // beforehand it wasn't possible to use Strings in switch statements.
        // we were able to use integers, and boolean for example:
        List<Integer> values = new ArrayList<Integer>();
        values.add(1);
        values.add(2);
        values.add(3);
        for (int i = 0; i < values.size(); i++) {
            Integer value = values.get(i);
            switch(value % 2) {
                case 0:
                    System.out.println(value + " is an even number!!" );
                    break;
                default:
                    System.out.println(value + " is odd number!!!");
            }
        }

        // with Java 7, we are able to write Strings in switch statements:
        List<String> strings = new ArrayList<String>();
        strings.add("Accounting");
        strings.add("IT");
        strings.add("HR");
        strings.add("Hi");

        for (int i = 0; i < strings.size(); i++) {
            String value = strings.get(i);
            switch(value) {
                case "Accounting" :
                    System.out.println("callAccounting()");
                    break;
                case "IT":
                    System.out.println("callIT()");
                    break;
                case "HR":
                    System.out.println("callHR()");
                    break;
                default:
                    System.out.println("Unknown department!");
            }
        }


    }

}
