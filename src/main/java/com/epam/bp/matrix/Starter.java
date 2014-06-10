package com.epam.bp.matrix;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        System.out.println("Matrix multiplication. There are two block matrices А and В with dimensions m*n and n*q accordingly." +'\n'+"Please enter m,n,q values: ");
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();
        
        System.out.println("Generating matrices. Matrix A with dimensions " + m + "*" + n + ":");
        Matrix A = new Matrix(m, n);
        A.fill();
        System.out.println(A.matrixToString());

        System.out.println("Matrix B with dimensions " + n + "*" + q + ":");
        Matrix B = new Matrix(n, q);
        B.fill();
        System.out.println(B.matrixToString());

        System.out.println("Product of A*B will be matrix C with dimensions " + m + "*" + q + ":");
        Matrix C = A.multiply(B);
        System.out.println(C.matrixToString());

    }


}