package org.example;

import java.util.*;

public class StudentDbWithHashMap {

    Map<Integer, Student> studentMap;

    public StudentDbWithHashMap(Map<Integer, Student> studentMap) {
        this.studentMap = studentMap;
    }

    @Override
    public String toString() {
        return "StudentDbWithHashMap{" +
                "studentMap=" + studentMap +
                '}';
    }

    public Map<Integer, Student> getAllStudentsAsHashMap() {
        return studentMap;
    }

    public Student randomStudentHashMap(Map<Integer, Student> studentMap) { // dafür müssen wir der Methode noch die HashMap mitgeben

        // Hier wird ein zufälliger Student aus der HashMap ausgewählt
        // indem wir eine Liste aus den Keys der HashMap erstellen und dann einen zufälligen Key auswählen
        // und dann den Studenten mit dem zufälligen Key aus der HashMap auswählen
        List<Integer> keys = new ArrayList<>(studentMap.keySet());
        Random random = new Random();
        int randomIndex = random.nextInt(keys.size());
        int randomKey = keys.get(randomIndex);
        return studentMap.get(randomKey);
    }

    public void addStudent(Student max) {
        studentMap.put(max.getId(), max);
    }

    public void removeStudent(Student studentToDelete) {
        studentMap.remove(studentToDelete.getId());
    }

    public Student findById(int id) throws StudentIdNotFoundException {
        if (studentMap.containsKey(id)) {
            return studentMap.get(id);
        } else {
            throw new StudentIdNotFoundException("Student with id " + id + " not found");
        }
    }
}
