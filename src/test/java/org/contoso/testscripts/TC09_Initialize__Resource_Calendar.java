package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC09_Initialize__Resource_Calendar extends BaseTest{
	
	@Test
	public void TC09_Initiate_Rsource_Calendar() throws InterruptedException
	{
		
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // INITIALIZE THE RESOURCE CALENDAR
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.InitializeResourceCalendar();
		  
		  // TEST CASE DONE
	}
}
