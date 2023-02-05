package oops_java_programming31jan2023;


public class Animal {

	public static void main(String[] args) {
		System.out.println("i am coding");
		secret();
		jail();
  //create object 
		Animal animal =new Animal() ;
		//call the object
		animal.loginTest();
	}
  private static void secret() {
	  System.out.println("i have written some secret code here in this method");
  }
  protected static void jail() {
	System.out.println("i have written some protected code here in tis method");
}
void loginTest() {
	System.out.println("i have written some default code here in this method");
}


}



