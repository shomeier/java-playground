package org.sho.generics;

import java.util.List;
import java.util.ArrayList;

public class UnboundedWildCards {

    void test() {

        // a list with an unbounded wiildcard is covariant like arrays
        // and therefore not type safe
        List<?> unboundedList = new ArrayList<>();
        unboundedList = new ArrayList<Integer>();

        // conpile error - note that if the compiler lets us do this
        // there would be runtime error later because Double is not Integer
        // unboundedList.add(Double.valueOf(3.4)); // compile error

        // thats why the compiler only allows you to insert 'null' into an unbounded list
        unboundedList.add(null);
    }
}

