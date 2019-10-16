package com.company.taks1;

public class Complex {
    private int mReal;
    private int mImag;

    public Complex(int real, int imag) {
        this.mReal = real;
        this.mImag = imag;
    }

    public Complex() {
        this(0, 0);
    }

    public Complex(Complex complex) {
        this.mReal = complex.getReal();
        this.mImag = complex.getImag();
    }

    public void addWithComplex(Complex number) {
        this.mReal += number.getReal();
        this.mImag += number.getImag();
    }

    public void showNumber() {
        System.out.println("(" + mReal + ", " + mImag + ")");
    }

    public int getReal() {
        return mReal;
    }

    public void setReal(int real) {
        this.mReal = real;
    }

    public int getImag() {
        return mImag;
    }

    public void setImag(int imag) {
        this.mImag = imag;
    }
}
