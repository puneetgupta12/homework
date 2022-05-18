package com.gupta.java.hackerrank.sapient.common;

import java.io.Serializable;

/**
 * @author tarhashm
 */
public class Square extends Rectangle implements Serializable {
    private static final long serialVersionUID = 20190326L;


    public Square(Integer shapeId, String name, Integer length) {
        super(shapeId, name, length, length);
    }


    @Override
    public String toString() {
        return "Square{" +
                "shapeId=" + super.getShapeId() +
                ", name='" + super.getName() +
                ", length=" + super.getLength() +
                ", breadth=" + super.getBreadth() +
                '}';
    }
}
