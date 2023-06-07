package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws StudentIdNotFoundException {

        Student[] studentArray = new Student[3];
        studentArray[0] = new Student("John", 1);
        studentArray[1] = new Student("Mary", 2);
        studentArray[2] = new Student("Bob", 3);

        StudentDbWithArray studentDbWithArray = new StudentDbWithArray(studentArray);


        // Aufgabe 3 = Die Methode getAllStudents() gibt alle Studenten als Array zurück
        System.out.println(studentDbWithArray.getAllStudents());

        // Aufgabe 4 = Die toString() Methode gibt alle Studenten als String zurück
        System.out.println(studentDbWithArray.toString()); // .toString() ist optional

        //Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück. Mit Casting
        System.out.println(studentDbWithArray.randomStudentWithCasting());

        // Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück. Ohne Casting
        System.out.println(studentDbWithArray.randomStudentWithoutCasting());

        // Bonus Aufgabe: Die Methode addStudentWithForLoop() fügt einen Studenten dem Array hinzu
        System.out.println("Vor dem hinzufügen eines Studenten: " + studentDbWithArray);
        studentDbWithArray.addStudentWithForLoop(new Student("Max", 4));
        System.out.println("Nach dem hinzufügen eines Studenten: " + studentDbWithArray);

        // Bonus Aufgabe: Die Methode addStudentWithArraysCopyOf() fügt einen Studenten dem Array hinzu
        System.out.println("Vor dem hinzufügen eines Studenten: " + studentDbWithArray);
        studentDbWithArray.addStudentWithArraysCopyOf(new Student("Konni", 5));
        System.out.println("Nach dem hinzufügen eines Studenten: " + studentDbWithArray);

        // Bonus Aufgabe: Die Methode removeStudent() entfernt einen Studenten aus dem Array
        System.out.println("Vor dem entfernen eines Studenten: " + studentDbWithArray);
        studentDbWithArray.removeStudent(studentArray[1]);
        System.out.println("Nach dem entfernen eines Studenten: " + studentDbWithArray);

        //Eigene Variante mit ArrayList

        ArrayList<Student> studentListNew = new ArrayList<>();
        studentListNew.add(new Student("Tobi", 1111));
        studentListNew.add(new Student("HHHHHH", 1112));


        StudentDbArrayListOwn studentDbArrayListOwn = new StudentDbArrayListOwn(studentListNew);

        System.out.println("Eigene ArrayList: " + studentDbArrayListOwn.getAllStudents());

        studentListNew.add(new Student("AAAAA", 1113));

        System.out.println("Eigene ArrayList: " + studentDbArrayListOwn.getAllStudents());

        //Hier die Variante mit einer ArrayList

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("John", 1));
        studentArrayList.add(new Student("Mary", 2));
        studentArrayList.add(new Student("Bob", 3));

        //oder auch so:
        // ArrayList<Student> studentArrayList = new ArrayList<>(Arrays.asList(studentArray));
        // oder:
        // ArrayList<Student> studentArrayList = new ArrayList<>(List.of(studentArray));
        // oder:
        // ArrayList<Student> studentArrayList = new ArrayList<>(List.of(new Student("John", 1), new Student("Mary", 2), new Student("Bob", 3)));

        StudentDbWithArrayList studentDbWithArrayList = new StudentDbWithArrayList(studentArrayList);

        // Aufgabe 3 = Die Methode getAllStudents() gibt alle Studenten als ArrayList zurück
        System.out.println("Als ArrayList: " + studentDbWithArrayList.getAllStudents());

        // Aufgabe 4 = Die toString() Methode gibt alle Studenten als String zurück
        System.out.println("Als String: " + studentDbWithArrayList.toString()); // .toString() ist optional

        //Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück. Mit Casting
        System.out.println(studentDbWithArrayList.randomStudentWithCasting());

        // Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück. Ohne Casting
        System.out.println(studentDbWithArrayList.randomStudentWithoutCasting());

        // Bonus Aufgabe: Die Methode addStudent() fügt einen Studenten der ArrayList hinzu
        System.out.println("Vor dem hinzufügen eines Studenten: " + studentDbWithArrayList);
        studentDbWithArrayList.addStudent(new Student("Max", 4));
        System.out.println("Nach dem hinzufügen eines Studenten: " + studentDbWithArrayList);

        // Bonus Aufgabe: Die Methode removeStudent() entfernt einen Studenten aus der ArrayList
        System.out.println("Vor dem entfernen eines Studenten: " + studentDbWithArrayList);
        studentDbWithArrayList.removeStudent(studentArrayList.get(1)); // hier kann man auch direkt ein Object übergeben => studentDbWithArrayList.removeStudent(studentX);
        System.out.println("Nach dem entfernen eines Studenten: " + studentDbWithArrayList);

        //Hier die Variante mit Hashmap<>


        HashMap<Integer, Student> studentHashMap = new HashMap<>();
        Student student1 = new Student("John", 1);
        Student student2 = new Student("Mary", 2);
        Student student3 = new Student("Bob", 3);

        StudentDbWithHashMap studentDbWithHashMap = new StudentDbWithHashMap(studentHashMap);

        studentHashMap.put(student1.getId(), student1); // hier der Unterschied zur ArrayList: wir müssen einen Key mitgeben
        studentHashMap.put(student2.getId(), student2); // als Key benutzen wir die ID des Studenten
        studentHashMap.put(student3.getId(), student3); // und die .add() Methode wird durch .put() ersetzt

        // Aufgabe 3 = Die Methode getAllStudents() gibt alle Studenten als HashMap zurück
        System.out.println("Als HashMap: " + studentDbWithHashMap.getAllStudentsAsHashMap());

        // Aufgabe 4 = Die toString() Methode gibt alle Studenten als String zurück
        System.out.println("Als String: " + studentDbWithHashMap.toString()); // .toString() ist optional

        // Aufgabe 5 = randomStudent() gibt einen zufälligen Studenten zurück. Mit Casting
        System.out.println(studentDbWithHashMap.randomStudentHashMap(studentHashMap)); // hier geben wir der Methode die Hashmap mit,
                                                                                       // damit wir aus dieser HashMap alle Keys herausziehen können

        // Bonus Aufgabe: Die Methode addStudent() fügt einen Studenten der HashMap hinzu
        System.out.println("Vor dem hinzufügen eines Studenten: " + studentDbWithHashMap);
        studentDbWithHashMap.addStudent(new Student("Max", 4));
        System.out.println("Nach dem hinzufügen eines Studenten: " + studentDbWithHashMap);

        // Bonus Aufgabe: Die Methode removeStudent() entfernt einen Studenten aus der HashMap
        System.out.println("Vor dem entfernen eines Studenten: " + studentDbWithHashMap);
        studentDbWithHashMap.removeStudent(student1);
        System.out.println("Nach dem entfernen eines Studenten: " + studentDbWithHashMap);

        System.out.println("Suche nach Student mit der ID 2: " + studentDbWithHashMap.findById(5));


    }

}
