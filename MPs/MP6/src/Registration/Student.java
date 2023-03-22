package Registration;

public class Student extends Person {
	private double gpa;
	private String major;

	public Student(String name, int age, String email, String major, double gpa) {
		super(name, age, email);
		this.gpa = gpa;
		this.major = major;
		// TODO Auto-generated constructor stub

	}

	@Override
	public String toString() {
		return "Student gpa=" + gpa + ", major=" + major + ", name=" + name + ", email=" + email;
	}

	
	public void registerCourse(Course courseName) {
//		if (courseName.currentEnroll <= courseName.maxSize) {
//			return;
//		}
//		for (int i = 0; i < courseName.currentEnroll; i++) {
//			if (courseName.roster[i].equals(this)) {
//				return;
//			}
//		}courseName.roster[courseName.currentEnroll] = this;
//		courseName.currentEnroll++;
		courseName.addStudent(this);
	}
}
