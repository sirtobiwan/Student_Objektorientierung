package org.example;

import java.util.Arrays;
import java.util.Random;

public class StudentDbWithArray {

    // Aufgabe 1 = Der Konstruktor nimmt ein Array von Studenten
    //             entgegen

    private Student[] studentArray;

    public StudentDbWithArray(Student[] studentArray) {
        this.studentArray = studentArray;
    }

    // Aufgabe 3 = Die Methode getAllStudents() gibt alle Studenten als Array zurück
    //             weswegen der Rückgabetyp Student[] ist

    public Student[] getAllStudents() {
        return studentArray;
    }

    // Aufgabe 4 = Die toString() Methode gibt alle Studenten als String zurück
    @Override
    public String toString() {
        return "StudentDb{" +
                "studentArray=" + Arrays.toString(studentArray) +
                '}';
    }

    //Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück
    //            Die Methode nutzt hier das casten zu einem int, um einen zufälligen Index zu erhalten
    public Student randomStudentWithCasting() {
        int random = (int) (Math.random() * studentArray.length);
        return studentArray[random];
    }

    //Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück
    //            Die Methode nutzt hier die Klasse Random, um einen zufälligen Index zu erhalten
    public Student randomStudentWithoutCasting(){
        Random random = new Random();
        int randomIndex = random.nextInt(studentArray.length);
        return studentArray[randomIndex];

        //man kann folgende Funktion auch wie folgt schreiben:
        //return studentArray[random.nextInt(studentArray.length)];
        }
    // Bonus Aufgabe: Die Methode addStudent() fügt einen Studenten dem Array hinzu
    public void addStudentWithForLoop(Student studentToAdd){
        Student[] newStudentArray = new Student[studentArray.length + 1];
        for (int i = 0; i < studentArray.length; i++) {
            newStudentArray[i] = studentArray[i];
        }
        newStudentArray[newStudentArray.length - 1] = studentToAdd;
        studentArray = newStudentArray;
    }
    public void addStudentWithArraysCopyOf(Student studentToAdd){
        studentArray = Arrays.copyOf(studentArray, studentArray.length + 1);
        studentArray[studentArray.length - 1] = studentToAdd;
    }

    // Bonus Aufgabe: Die Methode removeStudent() entfernt einen Studenten aus dem Array
    public void removeStudent(Student studentToRemove){
        Student[] newStudentArray = new Student[studentArray.length - 1];
        int index = 0;
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] != studentToRemove){
                newStudentArray[index] = studentArray[i];
                index++;
            }
        }
        studentArray = newStudentArray;
    }


}
