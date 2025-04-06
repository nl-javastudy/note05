//ObjectTest.java
public class ObjectTest {
	public static void main(String[] agrs) throws CloneNotSupportedException{
		Person p1 = new Person("곽동건", 23);
		Person p2 = new Person("곽동건", 23);
		Person p3 = p1.clone();
		
		//toString() 테스트
		System.out.println("p1: " + p1.toString());
		
		//equals() 테스트
		System.out.println("p1.equals(p2): " + p1.equals(p2));
		
		//hashCode() 테스트
		System.out.println("p1.hashCode() " + p1.hashCode());
		System.out.println("p2.hashCode() " + p2.hashCode());
		
		//getClass() 테스트
		System.out.println("p3: " + p3.toString());
		
		//clone() 테스트
		System.out.println("p3: " + p3.toString());
		System.out.println("p1 == p3: " + (p1 == p3));
	}
}