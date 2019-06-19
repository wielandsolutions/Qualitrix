package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;


public class TC08_Update_Location_Structure extends BaseTest {
	
	@Test
	public void TC08_UpdateLocationStructure () throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // SETUP STANDARD CALENDAR
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.UpdateLocationStructure();
		  
		  // TEST CASE DONE
	}
	
}
