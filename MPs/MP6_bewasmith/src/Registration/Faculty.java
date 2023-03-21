package Registration;

public class Faculty extends Person {
	public String department;
	public String office;
	public Faculty(String name, int age, String email,String department,String office) {
		super(name, age, email);
		this.department=department;
		this.office=office;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Faculty department=" + department + ", office=" + office + ", name=" + name + ", age=" + age
				+ ", email=" + email;
	}
	
}
