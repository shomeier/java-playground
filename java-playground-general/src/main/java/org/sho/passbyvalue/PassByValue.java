package org.sho.passbyvalue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }
}

/**
 * In Java all method arguments are always passed BY VALUE
 */
public class PassByValue {

    private static final Logger LOGGER = LoggerFactory.getLogger(PassByValue.class);

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;

        // we pass the object to foo
        tryReassign(aDog);
        // aDog variable is still pointing to the "Max" dog when tryReassign(...) returns
        LOGGER.info("Dog's name: {}", aDog.getName());
        LOGGER.info("aDog == oldDog: {}", aDog == oldDog);

        // we pass the object to foo
        setName(aDog);
        // aDog variable is still pointing to the old dog object when setName(...) returns
        // but we set the name inside that object to another value
        LOGGER.info("Dog's name: {}", aDog.getName());
        LOGGER.info("aDog == oldDog: {}", aDog == oldDog);
    }

    public static void tryReassign(Dog d) {
        LOGGER.info("Inside scope of foo - Dog's name: {}", d.getName());
        // change d inside of tryReassign() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        LOGGER.info("Inside scope of foo - Dog's name: {}", d.getName());
    }

    public static void setName(Dog d) {
        LOGGER.info("Inside scope of foo - Dog's name: {}", d.getName());
        // change d inside of setName() to point to a new Dog instance "Fifi"
        d.setName("Fifi");
        LOGGER.info("Inside scope of foo - Dog's name: {}", d.getName());
    }
}
