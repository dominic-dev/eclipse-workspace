package main;

import java.util.Comparator;

public class AverageGradeComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
        return (int) (o1.getAverageGrade() - o2.getAverageGrade());
	}
}
