package org.sho.methodarguments;

public class PrimitiveWrapperObjects {
    private static void changeInteger(Integer x) {
        x = 5;
    }

    public static void main(String[] args) {
        Integer x = 0;
        changeInteger(x);
        System.out.println(x);
    }
}
