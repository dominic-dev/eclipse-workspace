package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static String LINE = "==========================";
    public static void main(String[] args) {
        Student[] studenten = {
            new Student(3, "D", 5f),
            new Student(2, "E", 8f),
            new Student(1, "I", 3f),
            new Student(4, "G", 10f)
        };

        printStudenten(studenten);
        System.out.println(LINE);
        Collections.sort(Arrays.asList(studenten), new StudentNrComparator());
        printStudenten(studenten);
        System.out.println(LINE);
        Collections.sort(Arrays.asList(studenten), new LastNameComparator());
        printStudenten(studenten);
        System.out.println(LINE);
        Collections.sort(Arrays.asList(studenten), new AverageGradeComparator());
        printStudenten(studenten);
        System.out.println(LINE);

    }

    public static void printStudenten(Student[] studenten){
        for(Student s : studenten){
            System.out.println(s);
        }
    }


    public static void printStudenten(List<Student> studenten){
        for(Student s : studenten){
            System.out.println(s);
        }
    }

}
