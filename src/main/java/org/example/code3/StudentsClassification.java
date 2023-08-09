package org.example.code3;

import org.example.code3.Student;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsClassification extends Student {

    public StudentsClassification(String name, int score) {
        super(name, score);
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Frido" , 9),
                new Student("Mirinda" , 15),
                new Student("Bancho" , 8),
                new Student("Momona" , 19),
                new Student("Sendo" , 5),
                new Student("Lenoro" , 6),
                new Student("Rolfo" , 4),
                new Student("Romodo" , 18),
                new Student("Momona" , 17),
                new Student("Momona" , 2),
                new Student("Krodono" , 10)
        );

        System.out.println("All Students :");
        students.forEach(System.out::println);

        List<Student> above5 = students.stream()
                .filter(student -> student.getScore() > 5)
                .collect(Collectors.toList());

        System.out.println("------------------------------------------------");
        System.out.println("students with scores above 5 : ");
        above5.forEach(System.out::println);


        double averageScore = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);
        System.out.println("Average Score : " + averageScore);

        Student highestScoreStudent = students.stream()
                .max(Comparator.comparingInt(Student::getScore))
                .orElse(null);
        System.out.println("------------------------------------------------");
        System.out.println("Students with Highest score " + highestScoreStudent);

        List<Student> sortedStudents = students.stream()
                .sorted(Comparator.comparingInt(Student::getScore).reversed())
                .collect(Collectors.toList());

        System.out.println("-------------------------------------------------");
        System.out.println("Students Sorted by Score (Desending) : ");
        sortedStudents
                .forEach(System.out::println);

    }
}
