package xml_TESTNG;

import org.testng.annotations.Test;

public class Groups_TestNG {
	
	
	@Test(groups = {"Smoke"})
	public void test1() {
		System.out.println("Smoke Test");
	}
	@Test(groups = {"Smoke"})
	public void test2() {
		System.out.println("Smoke Test & Integration Test");
	}
	@Test(groups = {"Sanity"})
	public void test3() {
		System.out.println(" Sanity test");
	}
	@Test(groups = {"Smoke","Sanity"})
	public void test4() {
		System.out.println("Smoke Test & Sanity ");
	}
	

}
