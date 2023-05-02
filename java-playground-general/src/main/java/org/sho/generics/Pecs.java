package org.sho.generics;

import java.rmi.server.ObjID;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.ObjectFactory;

// producer extends consumer supers
public class Pecs {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();

        List<? super Number> dest = numberList;
        List<? super Number> dest2List = new ArrayList<Object>();
        dest.add(Integer.valueOf(10));
        dest2List.add(Integer.valueOf(10));

        List<? extends Number> src = intList;
        List<? extends Number> src2List = new ArrayList<Integer>();
        Number number = src.get(0);
        Number number2 = src2List.get(0);


        // the compiler uses 'Integer' for the concrete parameterized type
        copy(numberList, intList);

        // but both would work: Intege and Number
        copyExplInteger(numberList, intList);
        copyExplNumber(numberList, intList);
    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {

        T testMe;
        src.forEach(dest::add);

        // Object x = dest.get(0);
        // src.add(testMe);
    }

    public static void copyExplInteger(List<? super Integer> dest, List<? extends Integer> src) {

        src.forEach(dest::add);
    }

    public static void copyExplNumber(List<? super Number> dest, List<? extends Number> src) {

        src.forEach(dest::add);
    }


}
