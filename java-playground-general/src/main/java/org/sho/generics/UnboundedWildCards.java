package org.sho.generics;

import java.util.List;
import java.util.ArrayList;

public class UnboundedWildCards {

    public static void main(String args[]) {

        // an unbounded wildcard is simply a placeholder for one "specific but unknown type"
        // A List<?> is therefore completely different to List<Object> which can contain all kinds of objects:
        List<Object> objList = new ArrayList<>();
        objList.add(Integer.valueOf(10));

        // same as a "capture of bounded wildcards" is a placholder for one "specific but unknown type"
        List<? extends Number> testList = new ArrayList<>();

        // a list with an unbounded wildcard is covariant like arrays
        // and therefore not type safe
        List<?> unboundedList = new ArrayList<>();
        unboundedList = new ArrayList<Integer>();

        // conpile error - note that if the compiler lets us do this
        // there would be runtime error later because Double is not Integer
        // unboundedList.add(Double.valueOf(3.4)); // compile error

        // thats why the compiler only allows you to insert 'null' into an unbounded list
        unboundedList.add(null);

        // with arrays this works:
        Number[] numbers = new Number[10];
        numbers = new Integer[10];
        // runtime error - ArrayStoreException because a Double is not an Integer
        numbers[0] = Double.valueOf(3.4);


        // generics on collections are invariant
        // so the following is not allowed:
        List<Number> numberList = new ArrayList<>();
        // numberList = new ArrayList<Integer>(); does not compile

        // ... but this works
        List<? extends Number> numberList2 = new ArrayList<>();
        numberList2 = new ArrayList<Integer>();

        List<? super Integer> numberList3 = new ArrayList<>();
        numberList3 = new ArrayList<Number>();


        // same on all type parameterized classes
        var test = new Test<Object>();
        var test2 = new Test<Number>();

        // test = test2; does not compile

        // but of course this works
        var obj = new Object();
        var integer = Integer.valueOf(10);
        obj = integer;


        // when not using wildcards
        List<Integer> intList = new ArrayList<>();
        intList.add(Integer.valueOf(10));
        Integer myInt = intList.get(0);
    }

    static class Test<T> {

        private T test;

        public void test(Object t) {
        }
    }
}

