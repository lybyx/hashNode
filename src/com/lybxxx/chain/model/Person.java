package com.lybxxx.chain.model;

import java.util.Objects;

/**
 * @author lybxxx
 */
public class Person implements Comparable{
    String name;
    int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.age - p.age;
    }
}
