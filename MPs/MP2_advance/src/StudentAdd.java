import java.util.ArrayList;
import java.util.*;


class MySelectionSort {

public static <E extends Comparable> ArrayList<E> sort(ArrayList<E> input) {
        for (int i = 0; i < input.size(); i++) {
        int smallest = i;
        for (int j = i; j < input.size() - 1; j++) {
        if (input.get(smallest).compareTo(input.get(j + 1)) > 0) {
        smallest = j + 1;
        }
        }
        E temp = input.get(i);
        input.set(i, input.get(smallest));
        input.set(smallest, temp);
        }
        return input;
        }
        }

public class StudentAdd
{
    public static void main(String[] args)
    {

        ArrayList<Student> listStudents=new ArrayList<>();
        Student student1= new Student("Ben",3.3);
        Student student2= new Student("Shelby",4.0);
        Student student3= new Student("Josh",2.5);
        Student student4 = new Student("Jamie", 3.8);
        Student student5 = new Student("Adam", 3.4);
        Student student6 = new Student("Melody",2.9);

        listStudents.add(student1);
        listStudents.add(student2);
        listStudents.add(student3);
        listStudents.add(student4);
        listStudents.add(student5);
        listStudents.add(student6);


        System.out.println("array printed before sort");
        System.out.println(listStudents);


        System.out.println("\nsort using Selection Sort by Alphabetical Order");

        MySelectionSort mySelectionSort = new MySelectionSort();
        listStudents = mySelectionSort.sort(listStudents);

        System.out.println(listStudents);



    }


}