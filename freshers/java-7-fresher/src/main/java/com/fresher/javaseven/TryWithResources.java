package com.fresher.javaseven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * 2. Multiple exception handling
 * +++3. Try with resources
 * 4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * 7. Binary literals
 * 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class TryWithResources {
    public static void main(String[] args) throws IOException { // the ide says this is a cleaner way!
        // before java 7 we would need to close the open files (read resources) , for example in a 'finally' block:
        BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
        try {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.equals("EOF")) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred! " + ex.getMessage());
        } finally {
            reader.close();
            System.out.println("File is closed!");
        }

        // now after java 7 , it is possible to control the closing of the files in the try block.

        try (BufferedReader withResources = new BufferedReader(new FileReader("example2.txt"))) {
            while (withResources.ready()) {
                String line = withResources.readLine();
                if (line.equals("EOF")) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception ex) {
            System.out.println("Exception occurred! " + ex.getMessage());
        } finally {
            System.out.println("File is closed!");
        }

    }
}
