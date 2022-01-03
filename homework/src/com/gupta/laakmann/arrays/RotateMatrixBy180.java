package com.gupta.laakmann.arrays;

/*
    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
    write a method to rotate the image by 180 degrees. Can you do this in place?

    Input :  1  2  3
         4  5  6
         7  8  9

    Output : 9 8 7
         6 5 4
         3 2 1
 */
public class RotateMatrixBy180 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };

        System.out.println("Original Matrix: ");
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        rotateBy180(matrix);

        System.out.println("New Matrix: ");
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Rotate twice by 90 degrees
    private static void rotateBy180(int[][] matrix) {
        RotateMatrix.rotateBy90(matrix);
        RotateMatrix.rotateBy90(matrix);
    }
}
