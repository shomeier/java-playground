package org.sho.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UserComparator {

    public static void main(String... args) {

        User sarah = new User("Sarah", 28);
        User james = new User("James", 35);
        User mary = new User("Mary", 33);
        User john1 = new User("John", 24);
        User john2 = new User("John", 25);
        User john3 = new User("John", 26);

        List<User> users = Arrays.asList(sarah, james, mary, john2, john3, john1);

        // create Comparators using key extractors
        Comparator<User> cmpName = Comparator.comparing(user -> user.getName());
        Comparator<User> cmpAge = Comparator.comparingInt(user -> user.getAge());

        // chain the comparators to first sort by name and if name is euqual sort by age
        Comparator<User> comparator = cmpName.thenComparing(cmpAge);

        users.sort(comparator);
        users.forEach(System.out::println);
    }

    static class User {

        private final String name;
        private final int age;

        public User(final String name, final int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("Name: %s, Age: %s", name, age);
        }
    }
}

