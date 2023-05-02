package com.github.pedrovgs.problem81;

public class PascalTriangle {
    public static void main(String args[]){

        System.out.println();
        int n, i, j;
        n = 5;

        for(i = 0; i <= n; i++) {
            for(j = 0; j <= n-i; j++)
                System.out.print(" ");

            for(j = 0; j <= i; j++)
                System.out.print(" " + ncr(i, j));
        }
    }

    static int factorial(int n) {
        int f;
        for(f = 1; n > 1; n--)
            f *= n;
        return f;
    }

    static int ncr(int n,int r) {
        return factorial(n) / ( factorial(n-r) * factorial(r) );
    }
}
