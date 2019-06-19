package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC15_Publishing_The_Shifts extends BaseTest {
	@Test
	public void TC15_Publish_Shifts() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // NAVIGTE TO SCHEDULE PAGE
		  NewResourceSetupPage NewResourceSetupPage = new NewResourceSetupPage();
		  NewResourceSetupPage.NavigateToSchedulePageWithCurrentDate();
		  
		  // PUBLISH THE SHIFTS ASSIGNED
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.PublishTheShifts();
		  
		  // TEST CASE DONE
		  
	}
}
