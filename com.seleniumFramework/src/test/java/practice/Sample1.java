package practice;

import org.testng.annotations.Test;

public class Sample1 {

private static final String depend = null;
@Test
public void m1() {
	System.out.println("m1 is created");
	int arr[]= {1,2,3};
	System.out.println("5");
}
@Test(dependsOnMethods="m1")
public void m2() {
	System.out.println("m1 is modified");
}
@Test(dependsOnMethods="m1")
public void m3() {
	System.out.println("m1 is deleted");
}
}
