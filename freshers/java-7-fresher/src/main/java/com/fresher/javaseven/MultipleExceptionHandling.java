package com.fresher.javaseven;

import java.util.Arrays;
/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * +++2. Multiple exception handling
 * 3. Try with resources
 * 4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class MultipleExceptionHandling {
    public static void main(String[] args) {
        // our second topic is multiple exception handling.
        // before Java 7 you would only do:
        try {
            String[] stringArray = new String[2];
            stringArray[0] = "First String";
            stringArray[1] = "Second String";
            stringArray[2] = "Third String?"; // !some ides already warn you about the problem!

            // you will need to comment out the line above to throw this.
            stringArray[0] = null;
            System.out.println(Arrays.toString(stringArray[0].split(",")));
        } catch (IndexOutOfBoundsException ex) {
            // handle ex
            System.out.println("The operation for adding an element to array gets out of bounds");
            // warn the user with proper exception handling
            // return500(ex);
        } catch (NullPointerException ex) {
            // handle ex
            System.out.println("The operation for adding an element to array gets out of null pointer exception");
            // warn the user with proper exception handling
            // return500(ex);
        }

        // as you can see the exception handling does almost the same thing! (apart from the exception warning on the command line)
        // instead of cluttering all the handling logic and decreasing the readability and modifiability, java 7 introduced
        // multiple exception handling!
        try {
            String[] stringArray = new String[2];
            stringArray[0] = "First String";
            stringArray[1] = "Second String";
            stringArray[2] = "Third String?"; // !some ides already warn you about the problem!

            // you will need to comment out the line above to throw this.
            stringArray[0] = null;
            System.out.println(Arrays.toString(stringArray[0].split(",")));
        } catch (IndexOutOfBoundsException | NullPointerException ex) {
            // handle ex
            System.out.println("The operation failed because : " + ex.getLocalizedMessage());
            // warn the user with proper exception handling
            // return500(ex);
        }


    }
}
