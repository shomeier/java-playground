package org.sho.staticfields;

class MyClass {

    // both primitive vars will be initialized with 0
    int i;
    static int s;

    public void add1() {
        i++;
        s++;
    }
}


public class StaticFields {

    public static void main(String[] args) {

        MyClass varFirst = new MyClass();
        varFirst.add1();
        varFirst.add1();
        MyClass varSecond = new MyClass();
        varSecond.add1();
        System.out.println(varFirst.i + " " + varFirst.s + " " + varSecond.i + " " + varSecond.s);

    }
}
