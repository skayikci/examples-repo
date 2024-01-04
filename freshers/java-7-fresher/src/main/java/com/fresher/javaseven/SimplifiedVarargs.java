package com.fresher.javaseven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * 9. More precise rethrowing exceptions
 * +++ 10. Simplified varargs method declarations
 */
public class SimplifiedVarargs {
    public static void main(String[] args) {
        // before java 7 you wouldn't be able to do this:
        List<String> strings = new ArrayList<>();
        strings.add("Accounting");
        strings.add("IT");
        strings.add("HR");
        strings.add("Hi");

        printer(strings);

        printingInputs("This");
        printingInputs("This", "is");
        printingInputs("This", "is", "how");
        printingInputs("This", "is", "how", "we");
        printingInputs("This", "is", "how", "we", "do");
        printingInputs("This", "is", "how", "we", "do", "it");
    }

    private static void printingInputs(String... strings) {
        System.out.println(Arrays.toString(strings));
    }

    @SafeVarargs
    private static void printer(List<String>... strings) {
        System.out.println(strings[0].get(0));
    }


}
