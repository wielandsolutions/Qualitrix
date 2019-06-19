package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC03_Setup_StandardCalendar_ResourcePage extends BaseTest {

	@Test
	public void TC03_SetupStandardCalendarInResourcePage() throws Exception
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  
		  // SETUP STANDARD CALENDAR
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.SetStandardCalendarInResourcePage();
		  
		  // TEST CASE DONE
	}
	
}
