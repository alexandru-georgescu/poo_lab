package com.company.task2;

public class Student {
    private int id;
    private String name, surname;

    public Student (int id, String name, String surname) {
        this.id = id;
        this.name = name;

        //Problema 1: trebuia folosit this.surname deoarce albele variabile aveau numele surname
        //si nu stai ce trebuie sa asigneze.
        this.surname = surname;
    }

    // copy constructor - se copiaza un obiect
    public Student (Student st) {
        //Aici trebuie sa folosim get pentru fiecare mebru
        this.id = st.getId();
        this.name = st.getName();
        this.surname = st.getSurname();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show () {
        System.out.println(String.format("Name: %s\nSurname: %s\nStudent ID: %d\n", name, surname, id));
    }

}

class MainTask2 {
    public static void main (String[] args) {
        Student student1 = new Student (42, "Decebal", "Popescu");
        /*
            noi dorim sa facem o copie a obiectului student1, numita student2
            apoi sa modificam copia respectiva
        */

        //Aici trebuia sa facem un nou obiecte pe baza celui nou altfel fiecare o sa aibe aceasi referinta
        //Si ar fi modificat ambele objecte simultan
        Student student2 = new Student(student1);

        student2.setName("Cezar");
        student2.setSurname("Ghiu");

        /*
            trebuie sa afiseze
            Name: Decebal
            Surname: Popescu
            Student ID: 42
        */
        student1.show();

        /*
            trebuie sa afiseze
            Name: Cezar
            Surname: Ghiu
            Student ID: 42
        */
        student2.show();
    }
}
