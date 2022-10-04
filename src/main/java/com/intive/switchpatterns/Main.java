package com.intive.switchpatterns;

import com.intive.patternmatchingrecords.Color;

public class Main {
    public static void main(String[] args) {
        System.out.println(formatterPatternSwitch("2"));
        testFooBar(null);
        System.out.println(testString("a"));

    }
//lables
    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> o.toString();
        };
    }

    //pokazać  Dominance
    //1
    static void testString_(Object o) {
        switch (o) {
            case String s -> System.out.println("String "+s);
            case CharSequence cs -> System.out.println(cs);
            default -> System.out.println("something else");

        }
    }

    // dominance 2 //guarded
    static String testString(Object o) {
        return switch (o) {
            case String s when s.length() == 1 -> "short String";
            case String s -> "other string";
            default -> "something else";

        };
    }

// pokazać null
    static void testFooBar(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }
    // pokazać exhaustiveness
    static void testExhaustiveness(Object o) {
        switch (o) {
            case null -> System.out.println("Oops");
            case String s when s.equals("Foo") || s.equals("Bar")
                -> System.out.println("Foo or Bar");
            case String s -> System.out.println("Other String");
            default -> System.out.println("Ok");
        }
    }

}
