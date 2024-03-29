package org.sho.interfaces;

public class Beetle extends Insect {

    // MUST BE PUBLIC as abstract methods in interfaces are implicitly public and overriden methods are not allowed to reduce visiblity
    @Override
    public int getNumberOfSections() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfSections'");
    }

    @Override
    int getNumberOfLegs() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumberOfLegs'");
    }

}
