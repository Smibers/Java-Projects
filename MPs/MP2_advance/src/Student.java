class Student implements Comparable <Student>{
    private String name;
    private int ID;
    private double Gpa;
    private static int maxid=0;
    @Override
    public String toString()
    {
        return "Student{" + "name='" + name + '\'' + ", ID Number=" + ID + ", GPA=" + Gpa + '}';
    }

    public Student(String name,  double gpa)
    {
        this.name = name;
        this.setID();
        this.Gpa = gpa;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getID()
    {
        return ID;
    }

    public void setID() {
        this.ID=maxid;
        maxid++;
    }

    public double getGpa()
    {
        return Gpa;
    }

    public void setGpa(double gpa)
    {
        this.Gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {

        return this.name.compareTo(o.name);
    }
//    public int compareTo(Student o)
//    {
//        return Double.compare(o.Gpa,Gpa);
//    }
}