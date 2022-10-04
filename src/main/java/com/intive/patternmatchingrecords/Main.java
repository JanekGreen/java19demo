package com.intive.patternmatchingrecords;

public class Main {
    public static void main(String[] args) {
        //JDK 16
        Object o = "Ala ma kota";
        if(o instanceof String s){
            System.out.println("Value: "+s);
        }
        Object point = new Point(2,4);
        printSum(point);
        printSumNew(point);
        Object r = new Rectangle(new ColoredPoint(new Point(-2,8), Color.BLUE),new ColoredPoint(new Point(8,-2), Color.RED));
        printColorOfUpperLeftPoint((Rectangle) r);
        printUpperLeftColoredPoint((Rectangle) r);
    }
    //JDK 16
    static void printSum(Object o) {
        if (o instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x+y);
        }
    }
    //JDK 19
    static void printSumNew(Object o) {
        if (o instanceof Point(int x, int y)) {
            System.out.println(x+y);
        }
    }
    static void printUpperLeftColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }
    static void printColorOfUpperLeftPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point p, Color c),
                ColoredPoint lr)) {
            System.out.println(c);
        }
    }
}
