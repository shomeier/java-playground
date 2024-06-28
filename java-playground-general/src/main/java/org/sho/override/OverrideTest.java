package org.sho.override;

class Food {
    public String toString(){
        return "Normal Food";
    }
}

class Flesh extends Food {
    public String toString(){
        return "Flesh Food";
    }
}

class Animal {
    public void eat(Food food){
        System.out.println("Animal eats "+ food);
    }
}

class Dog extends Animal{

    // This is no override !!!
    // It is an overload !!! The parameter type must match exactly!
    // Only for the return type of an overloaded method the type must be covariant, not for the parameter type!
    // @Override
    public void eat(Flesh flesh){
        System.out.println("Dog eats "+ flesh);
    }
}

public class OverrideTest {

    public static void main(String[] args) {

        Animal animal = new Dog();

        Flesh flesh = new Flesh();

        animal.eat(flesh);
    }
}
