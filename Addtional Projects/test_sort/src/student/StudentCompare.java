package student;


import java.util.ArrayList;

class Student implements Comparable<Student>{
    private String name;
    private int id;
    private double gpa;
    private static int maxId = 0;

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
        this.setId();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
        
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }
    public void setId() {
        this.id = maxId;
        maxId++;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student(" +
                "Name='" + name + '\'' +
                ", ID=" + id +
                ", GPA=" + gpa +
                ')';
    }
}

public class StudentCompare{
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Student bob = new Student("Bob", 3.4);
        Student tommy = new Student("Tommy", 4.0);
        Student billy = new Student("Billy", 2.5);
        Student alice = new Student("Alice", 3.7);
        Student jorge = new Student("Jorge", 4.0);
        Student floyd = new Student("Floyd", 2.1);

        students.add(alice);
        students.add(tommy);
        students.add(jorge);
        students.add(bob);
        students.add(billy);
        students.add(floyd);

        System.out.println(students);

        MySelectionSort mySelectionSort = new MySelectionSort();
        students = mySelectionSort.sort(students);

        System.out.println();
        System.out.println(students);

    }
}

