package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC07_Adhoc_Tasks extends BaseTest{
	
	  NewResourceSetupPage NewResourceSetupPage = new NewResourceSetupPage();


	@Test
	public void TC07_Add_Shift_Tasks() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // ADHOC TASKS WHILE CREATING SHIFT REQUIREMENTS
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.AdhocTasks();
		  

	}

}


