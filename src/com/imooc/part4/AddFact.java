package com.imooc.part4;

public class AddFact {
    public static void main(String[] args) {
        int i, j;
        long fact = 1, sum = 0;
        for (i = 0; i <= 10; i++) {
            for (j = 1; j <= i; j++) {
                fact *= j;
            }
            sum += fact;
            System.out.println("sum=" + sum);
            fact = 1;
        }
        System.out.println("1!+2!+3!……+10!=" + sum);
    }
}