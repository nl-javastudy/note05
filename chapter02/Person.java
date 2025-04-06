//Person.java
public class Person implements Cloneable {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person[name = " + name + ", age = " + age + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Person person = (Person) obj;
		return age == person.age && name.equals(person.name);
	}
	
	@Override
	public int hashCode() {
		return 31 * name.hashCode() + age;
	}
	
	@Override
	public Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}
}