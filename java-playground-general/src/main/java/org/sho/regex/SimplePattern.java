package org.sho.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplePattern {
    public static void main(String[] args) {

        oneMatch();
        multiMatch();

    }

    private static void oneMatch() {
        // This will match a sequence of 1 or more uppercase and lowercase English letters as well as spaces
        String myRegExString = "[a-zA-Z\\s]+";

        // This is the string we will check to see if our regex matches:
        String myString = "The quick brown fox jumped over the lazy dog...";

        // Create a Pattern object (compiled RegEx) and save it as 'p'
        Pattern p = Pattern.compile(myRegExString);

        // We need a Matcher to match our compiled RegEx to a String
        Matcher m = p.matcher(myString);

        // if our Matcher finds a match
        if (m.find()) {
            // Print the match
            // Notice that the ellipsis (...) at the end of the myString was not printed as part of the match;
            // that is because myRegExString only matches lowercase and uppercase English letters and spaces—not
            // punctuation. Thus, the ellipsis serves as a boundary for the end of our matched text.
            System.out.println(m.group());
        }
    }

    private static void multiMatch() {

        String s = "Hello, Goodbye, Farewell";
        Pattern p = Pattern.compile("\\p{Alpha}+");
        Matcher m = p.matcher(s);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}
