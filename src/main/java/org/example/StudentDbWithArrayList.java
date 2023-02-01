package org.example;

import java.util.ArrayList;
import java.util.Random;

public class StudentDbWithArrayList {

    ArrayList<Student> studentList;

    public StudentDbWithArrayList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

    @Override
    public String toString() {
        return "StudentDbWithArrayList{" +
                "studentList=" + studentList +
                '}';
    }

    public Student randomStudentWithCasting() {
        int randomIndex = (int) (Math.random() * studentList.size());
        return studentList.get(randomIndex);
    }

    public Student randomStudentWithoutCasting(){
        Random random = new Random();
        int randomIndex = random.nextInt(studentList.size()); // Unterschied zum Array: hier wird die Größe des Arrays mit .size() abgefragt
        return studentList.get(randomIndex);
    }

    public void addStudent(Student studentToAdd){
        studentList.add(studentToAdd); // deutlich einfacher als im Array. Da wir uns bei ArrayLists nicht um die Größe kümmern müssen und
                                       // die Methode add() bereits vorhanden ist
    }

    public void removeStudent(Student studentToRemove){
        studentList.remove(studentToRemove); // hier ist es genauso wie bei add() nur das wir uns hier um das Entfernen eines Elements kümmern
                                             // und die Methode remove() bereits vorhanden ist
    }
}
