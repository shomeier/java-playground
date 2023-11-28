package org.sho.inheritance.pond;

import org.sho.inheritance.pond.swan.Swan;

public class SwanAccess {

    public void accessSwan() {
        Swan other = new Swan();
        // other.floatInWater();            // does not compile because we are in different package
        // System.out.println(other.text);  // does not compile because we are in different package
    }
}
