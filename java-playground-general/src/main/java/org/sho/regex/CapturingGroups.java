package org.sho.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingGroups {
    public static void main(String[] args) {

        extract();
    }

    private static void extract() {

        String url = "/dam/assets/{storageElementId}/previews/cnt";

        // we want the first path component ('dam')
        String regEx = "^/([a-zA-Z]+)/.*$+";

        Matcher m = Pattern.compile(regEx).matcher(url);
        if (m.matches()) {
            // the group at index 0 is always the entire string that matched
            System.out.println(m.group(1));
        }
    }
}
