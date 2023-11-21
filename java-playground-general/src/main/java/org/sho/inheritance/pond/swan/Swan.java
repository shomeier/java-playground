package org.sho.inheritance.pond.swan;

import org.sho.inheritance.pond.shore.Bird;

public class Swan extends Bird {

    public void swin(){
        floatInWater();
        System.out.println(text);
    }

    public void helpOtherSwanSwim() {
        Swan other = new Swan();
        other.floatInWater();
        System.out.println(other.text);
    }

    public void helpOtherBirdSwim() {
        Bird other = new Bird();
        other.floatInWater();
        System.out.println(other.text);
    }
}
