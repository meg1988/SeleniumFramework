package com.megha.SeleniumFramework.SeleniumFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Grouping {
  
	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("This is before class");
	  }
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.out.println("This is before method");

	}
	
	
	@Test(groups = {"sedan","BMW"}, enabled=false)
	public void BMW3() {
		System.out.println("This is BMW 3 series");
	}
	
	@Test(groups = {"SUV","BMW"},priority = 2)
	public void BMWX5() {
		System.out.println("This is BMW X5 series");
	}
	
	@Test(groups = {"sedan","Audi"}, priority = 1)
	public void AudiA6() {
		System.out.println("This is Audi A6 series");
	}
	
	@Test(groups = {"sedan","Nissan"}, priority = 0)
	public void NissanSentra() {
		System.out.println("This is Nissan sentra series");
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		System.out.println("This is after method");

	}

  

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("This is after class");

	}

}
