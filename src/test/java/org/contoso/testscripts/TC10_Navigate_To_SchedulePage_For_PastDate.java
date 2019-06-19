package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC10_Navigate_To_SchedulePage_For_PastDate extends BaseTest{

	@Test
	public void TC10_Navigate_To_SchedulePage_With_PastDate() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // NAVIGATE TO SCHEDULE PAGE
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.NavigateToSchedulePageWithPastDate();
		  
		  // TEST CASE DONE
	}
}

