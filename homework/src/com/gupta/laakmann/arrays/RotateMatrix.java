package com.gupta.laakmann.arrays;

/*
    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
    write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class RotateMatrix {
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

        rotateBy90(matrix);

        System.out.println("New Matrix: ");
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateBy90(int[][] matrix) {
        int len = matrix.length;

        //Transpose the matrix: basically, make the rows columns and vice versa keeping the diagonal same
        for (int i=0; i<len; i++) {
            for (int j=i; j<len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //reverse each row
        for (int i = 0; i<len; i++){
            for(int j = 0; j<len/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = temp;
            }
        }
    }
}
