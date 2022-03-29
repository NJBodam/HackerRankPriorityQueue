package priorityqueue;

public class Student {
    int id;
    String name;
    double cgpa;

    public Student(String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public Student() {

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCgpa() {
        return this.cgpa;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cgpa=" + cgpa +
                '}';
    }
}


