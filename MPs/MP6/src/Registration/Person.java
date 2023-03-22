package Registration;

public abstract class Person {
	protected String name;
	protected int age;
	protected String email;
	
	public Person() {
		name="";
		email="";
		age=0;
	}

	public Person(String name, int age, String email) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
	}

}
