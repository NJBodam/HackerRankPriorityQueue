package priorityqueue;

import java.util.*;
import java.util.stream.Collectors;

public class Priorities {

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
                if (o1.cgpa < o2.cgpa) {
                    return 1;
                } else if(o1.cgpa > o2.cgpa) {
                    return -1;
                } else {
                    int compareName = o1.name.compareTo(o2.name);
                    if (compareName != 0) {
                        return compareName;
                    } else {
                        return o1.id - o2.id;
                    }
                }
            }
        }


    public static ArrayList<String> getStudents(List<String> events) {
        StudentComparator comparator = new StudentComparator();
        PriorityQueue<Student> pr = new PriorityQueue<>(Integer.parseInt(events.get(0)), comparator);

        events.remove(0);

        for (int i = 0; i < events.size(); i++) {
            if(events.get(i).startsWith("ENTER")) {
                String[] event = events.get(i).split(" ");
                pr.add(new Student(event[1], Double.parseDouble(event[2])));
            } else if(events.get(i).startsWith("SERVED")) {
                pr.poll();
            }

        }

        return pr.stream().map(Student::getName).collect(Collectors.toCollection(ArrayList::new));

    }
}
