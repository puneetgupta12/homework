package com.gupta.java.hackerrank.sapient;

import com.gupta.java.hackerrank.sapient.common.Rectangle;
import com.gupta.java.hackerrank.sapient.common.Shape;
import com.gupta.java.hackerrank.sapient.common.Square;

import java.util.ArrayList;
import java.util.List;

public class SuperclassTest {
    public static void main(String[] args) {
        Shape shape = new Shape(100, "Circle");
        Rectangle rectangle = new Rectangle(1, "Rectangle One", 5, 3);
        Square square = new Square(3, "Square One", 5);

        List<String> superClazzes = findSuperClasses(square.getClass());

        System.out.println("Is Rectangle a super class? " + superClazzes.contains(rectangle.getClass().getName()));
        System.out.println("Is Circle a super class? " + superClazzes.contains("java.lang.Circle"));
    }

    public static List<String> findSuperClasses(Class<?> clazz) {
        List<String> clazzes = new ArrayList<>();

        for (; !clazz.getName().equals("java.lang.Object"); clazz = clazz.getSuperclass()) {
            clazzes.add(clazz.getSuperclass().getName());
        }

        return clazzes;
    }
}
