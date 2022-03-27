package priorityqueue;

import java.util.*;

public class Priorities {

    static class StudentComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            Queue<Student> priorityQueue = new PriorityQueue<>((person1, person2) -> {
                if(o1.getName() < o2.getName()) {
                    return -1;  // would sort based on ascending order
                } else if(person1.getRole().getPriority() > person2.getRole().getPriority()) {
                    return 1;
                } else {
                    return 0;
                }
            });

            if(o1.cgpa == o2.cgpa) {
              //  return (o1.getName() - o2.getName());

            }
            return (int) (o1.cgpa - o2.cgpa);
        }
    }


    public static List<Student> getStudents(List<String> events) {
        List empty = new ArrayList(List.of("EMPTY"));
        StudentComparator comparator = new StudentComparator();
        PriorityQueue<Student> pr = new PriorityQueue<>(Integer.parseInt(events.get(0)), comparator);
        events.remove(0);

        for (int i = 0; i < events.size(); i++) {
            if(events.get(i).startsWith("ENTER")) {
                String[] event = events.get(i).split(" ");
                Student student = new Student();
                student.setId(Integer.parseInt(event[3]));
                student.setName(event[1]);
                student.setCgpa(Double.parseDouble(event[2]));
                pr.add(student);
            } else if(events.get(i).startsWith("SERVED")) {
                pr.poll();
            }


        }

        System.out.println(">>>>>>>>>." + pr.stream().toList());

           return new ArrayList<>(pr);

    }
}
