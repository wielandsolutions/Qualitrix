package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC11_Navigate_To_SchedulePage_For_FutureDate extends BaseTest{

	@Test
	public void TC11_Navigate_To_SchedulePage_With_FutureDate() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // NAVIGATE TO SCHEDULE PAGE
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.NavigateToSchedulePageWithFutureDate();
		  
		  // TEST CASE DONE
	}
}

