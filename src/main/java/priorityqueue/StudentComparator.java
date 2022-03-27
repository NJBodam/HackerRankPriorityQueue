package priorityqueue;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {
    String events;
    @Override
    public int compare(Student o1, Student o2) {
        return (int) (o1.cgpa - o2.cgpa);
    }
}
