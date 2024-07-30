package org.sho.format.number;

import java.text.*;

public class DecimalFormatSample {

    public static void main(String[] args) {

        final DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Formatted: " + df.format(0.012345));

    }
}
