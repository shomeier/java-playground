package org.sho.inheritance;

public class Child extends Parent{

    // fails without having explicit ctor
    // since compiler trying to add dflt ctor fails because parent has no deflt ctor
    Child() {
        super("");

        // variables of the super class can be accessed via 'this' keyword
        this.test = "test";
    }
}
