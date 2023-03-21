package IO;

import java.io.*;
import java.util.Scanner;

class Person implements Serializable {
    //fill in the code
    String name;

    int year;

    public Person(String name, int year) {
        this.name= name;
        this.year= year;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + "'" +
                ", year=" + year +
                '}';
    }


}

public class MP1PersonIO {
    String fileName;
    int count=0;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    static Scanner kbInput = new Scanner(System.in);

    public MP1PersonIO(String fileName) {

        String name= fileName;



        try {
            this.ois = new ObjectInputStream(new FileInputStream(name));
        } catch (Exception e) {

        }

        try{
            this.oos = new ObjectOutputStream(new FileOutputStream(name));
        } catch (Exception e) {

        }
    }
    void close()  {
        try {
            this.oos.close();
            this.ois.close();
        }catch(Exception e){

        }
    }

        //fill in the code
        //set fileName
        //construct ObjectInputStream ois using fileName
        //construct ObjectOutputStream oos using fileName


    public void add() {
        Scanner scan = new Scanner(System.in);
        System.out.println("what is the persons name?");
        String Addname = scan.nextLine();
        System.out.println("what is the persons age?");
        int Addage = scan.nextInt();
        try {
            this.oos.writeObject(new Person(Addname, Addage));
            this.oos.flush();
            this.count++;
        }catch(IOException e) {

        }

    }

    public void display() {
        try {

            for (int i = 0; i < count;  i++) {
                Person e = (Person) this.ois.readObject();
                System.out.println(e);
            }
        }catch(IOException | ClassNotFoundException ex){
            System.out.println("end of file.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MP1PersonIO mp1 = new MP1PersonIO("person.ser");
        try {
            int option = -1;
            while (option != 0) {
                System.out.println("Please choose an option:");
                System.out.println("0: quit");
                System.out.println("1: add");
                System.out.println("2: display");
                option = kbInput.nextInt();
                kbInput.nextLine();
                switch (option) {
                    case 0:
                        System.out.println("Bye");
                        break;
                    case 1:
                        //invoke add
                        mp1.add();
                        break;


                    case 2:
                        mp1.display();
                        break;
                        //invoke display
                }

            }
        } finally {
            //close oos
            //close ois
            mp1.close();


        }

    }

}
