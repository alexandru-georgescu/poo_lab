package com.company;

import com.company.taks1.Complex;
import com.company.task3.Point;
import com.company.task3.Polygon;
import com.company.task4.Book;

public class Main {

    public static void main(String[] args) {

        /**
         * Task1 :  Construieste 3 obiecte de tip complex si apeleaza metode de adaugare si printare pentru a verifica
         * functionalitatea codului.
         */

        System.out.println("======== TASK1 ========");
        Complex number1 = new Complex();
        number1.showNumber();

        Complex number2 = new Complex(10, 12);
        Complex number3 = new Complex(number2);

        number1.addWithComplex(number3);
        number1.showNumber();

        System.out.println("======== TASK3 ========");

        /**
         * Task3 : Creeaza un punct, il afiseaza, creeaza un poligon si il afiseaza.
         */
        Point p1 = new Point(1, 2);
        p1.showPoint();
        float[] pointsVector = {1F,2F,3F,4F,5F,6F,7F,8F,9F,10F};
        Polygon polygon = new Polygon(pointsVector);


        System.out.println("======== TASK3 ========");
        /**
         * Task4 : Se construiesc obiecte de tip Book iar mai apoi se afiseaza informatii despre ele.
         */
        Book b1 = new Book("Morometii", "Marin Preda", 1955);
        System.out.println(b1);

        Book b2 = new Book("Levantul", "Mircea Cărtărescu", 1990);
        System.out.println(b2);
    }
}
