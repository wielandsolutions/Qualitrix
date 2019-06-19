package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC01_Employee_Creation extends BaseTest {
  @Test
  public void TC01_EmployeeCreation() throws Exception {
	  
	 
	  
	  // LOGIN AS SCHEDULER
	  LoginPage SchedulerLogin = new LoginPage();
	  SchedulerLogin.userLogin(SCHEDULER);
	  
	  // NEW EMPLOYEE CREATION
	  NewResourceSetupPage EmployeeCreation = new NewResourceSetupPage();
	  EmployeeCreation.NewEmployeeSetup();
	    
	  // GET EMPLOYEE PERSONNEL NUMBER
	  EmployeeCreation.GetEmployeePersonnelNumber();
  }
}
