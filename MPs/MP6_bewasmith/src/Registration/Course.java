package Registration;

public class Course {
	public String department;
	public String courseName;
	public int maxSize;
	public int currentEnroll;
	public Student[] roster;
	public Faculty instructor;

	public Course(String department, String courseName, int maxSize) {
		super();
		this.department = department;
		this.courseName = courseName;
		this.maxSize = maxSize;
		roster=new Student[maxSize];
	}

	void assignInstructor(Faculty instruct) {
		if (instruct.department.equals(department)) {
			instructor = instruct;
		}
	}

	public void addStudent(Student name) {
		if (currentEnroll >= maxSize) {
			System.out.println("class is full");
			return;
		}
		for (int i = 0; i < currentEnroll; i++) {
			if (roster[i].equals(name)) {
				System.out.println("student is already in class");
				return;
			}
			
		}
		roster[currentEnroll] = name;
		currentEnroll++;
		System.out.println(name + " is added");
		
//		for(int i=0;i<maxSize;i++) {
//			if(roster[i]==null) {
//				roster[i]=name;
//				break;
//			}if(roster[i]== null) {
//				System.out.println("spot is full");
//				break;
//			}
//		}
	}

	@Override
	public String toString() {
		return "Course department=" + department + ", course name=" + courseName + ", max class size=" + maxSize
				+ ", current number enrolled=" + currentEnroll + ", instructor=" + instructor;
	}

	public void displayRoster() {
		String str="";
		if (currentEnroll>0){
			for (int i = 0; i < currentEnroll; i++) 
			{
			str += roster[i].toString()+", ";
			
			}
		}System.out.println(str);
	}

}
