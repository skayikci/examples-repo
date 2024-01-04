package com.fresher.javaseven;

/**
 * The most famous new features are as follows:
 * 1. Strings in switch
 * 2. Multiple exception handling
 * 3. Try with resources
 * 4. Enhanced For loop
 * 5. Type inference
 * 6. Diamond Operator
 * +++ 7. Binary literals
 * +++ 8. Underscore literals
 * 9. More precise rethrowing exceptions
 * 10. Simplified varargs method declarations
 */
public class BinaryAndUnderscoreLiterals {
    public static void main(String[] args) {
        // beforehand you wouldn't be able to implement a binary directly from a field value,
        // so you could only do it either with your own algorithm, or some string magic.
        // with java 7:
        int binaryFive = 0b101;
        int humanReadableFive = 5;
        System.out.println("Binary value: " + binaryFive);
        System.out.println("Human readable value: " + humanReadableFive);
        System.out.println("Is Binary value and Human readable value equal?: " + (binaryFive == humanReadableFive));

        // you could also not read the numbers easily, if you have more than 6 figures.
        int aBillion = 1000000000;
        // with java 7 it is much more readable, isn't it?
        int aBillionWithUnderscore = 1_000_000_000;
        System.out.println("Previously : " + aBillion);
        System.out.println("After Java 7 : " + aBillionWithUnderscore);
        System.out.println("Is the previous and java 7 version equal? : " + (aBillion == aBillionWithUnderscore));
    }
}
