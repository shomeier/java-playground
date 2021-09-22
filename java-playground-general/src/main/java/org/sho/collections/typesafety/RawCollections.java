package org.sho.collections.typesafety;

import java.util.ArrayList;


class MyClass {

    private String s;

    public MyClass(String s) {
        this.s = s;
    }

    public String toString() {
        return s;
    }

}


public class RawCollections {

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("foo");
        list.add("bar");

        // myclass is sucessfully added to the list (raw type collections hold values of type Object)
        MyClass myClass = new MyClass("Baz");
        list.add(myClass);

        // [foo, bar, Baz]
        System.out.println(list);
    }
}
