package com.megha.SeleniumFramework.SeleniumFramework;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.*;
import org.testng.reporters.*;

import junit.framework.Assert;

public class TestNG_ReportersAndAsserts {
  @Test
  public void testStrings() {
	  
	  String actualValue = "Test Reporters And Asserts";
	  Reporter.log("The actual string is : " + actualValue, true);
	  Assert.assertEquals("Test Reporters And Asserts", actualValue);
	  Reporter.log("Verifying the actual string with expected string", true);
	  Reporter.log("",true);
  }
  
  @Test
  public void testInts() {
	  
	  int actualValue = 10;
	  Reporter.log("The actual int is : " + actualValue, true);
	  Assert.assertEquals(10, actualValue);
	  Reporter.log("Verifying the actual int with expected int", true);
	  Reporter.log("",true);

  }
  
  @Test
  public void testArrays() {
	  
	  int[] actualArray = {1,2,3};
	  int[] expectedArray = actualArray;

	  Reporter.log("The actual array is : " + actualArray, true);
	  Assert.assertEquals(expectedArray ,actualArray);
	  Reporter.log("Verifying the actual array with expected array", true);
	  Reporter.log("",true);
  }
}
