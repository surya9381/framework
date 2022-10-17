package practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
@Test
public void createCustomerTest() {
	System.out.println("step1");
	System.out.println("step2");
	
	SoftAssert soft=new SoftAssert();
	soft.assertEquals("A","B");
	System.out.println("step3");
	System.out.println("step4");
	soft.assertAll();
}
@Test
public void modifyCustomerTest() {
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
}
}
