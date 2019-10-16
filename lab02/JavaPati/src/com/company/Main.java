package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String op = scanner.next();
            if (op.equals("add")) {
                int nr1 = scanner.nextInt();
                int nr2 = scanner.nextInt();

                System.out.println("Rez: " + calculator.add(nr1, nr2));
            }

            if (op.equals("sub")) {
                int nr1 = scanner.nextInt();
                int nr2 = scanner.nextInt();

                System.out.println("Rez: " + calculator.sub(nr1, nr2));
            }

            if (op.equals("mul")) {
                int nr1 = scanner.nextInt();
                int nr2 = scanner.nextInt();

                System.out.println("Rez: " + calculator.mul(nr1, nr2));
            }

            if (op.equals("pow")) {
                int nr1 = scanner.nextInt();

                System.out.println("Rez: " + calculator.pow(nr1));
            }


        }
    }
}
