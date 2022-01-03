package com.gupta.laakmann.arrays;

/*
    Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 0},
            {9, 10, 11, 12},
        };

        /*
            Before:
            {1, 2, 3, 4},
            {5, 6, 7, 0},
            {9, 10, 11, 12}

            After:
            1, 2, 3, 0,
            0, 0, 0, 0,
            9, 10, 11, 0

            Before:
            1 0 3 4
            5 6 7 0
            9 10 11 12

            After:
            0 0 0 0
            0 0 0 0
            9 0 11 0
         */

        System.out.println("Before: ");
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        zeroMatrix(matrix);

        System.out.println("After: ");
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void zeroMatrix(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length]; //Note: columns value length here

        //So that we know which rows and columns are 0
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        //Iterate over rows and mark all numbers in that row as 0
        for (int i=0; i<matrix.length; i++) {
            if (row[i] == true) {
                for (int j=0; j<matrix.length; j++) {
                    matrix[i][j] = 0; //Mark all elements in that row i as 0
                }
            }
        }

        //Iterate over columns and mark all numbers in that columns as 0
        for (int x=0; x<matrix[0].length; x++) {
            if (col[x] == true) {
                for (int y=0; y<matrix.length; y++) {
                    matrix[y][x] = 0;
                }
            }
        }
    }
}
