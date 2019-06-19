package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC13_Manual_Assignment_Of_Shifts extends BaseTest {

	@Test
	public void TC13_Manually_Assigning_The_Shifts() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // NAVIGATE TO SCHEDULE PAGE
		  NewResourceSetupPage NewResourceSetupPage = new NewResourceSetupPage();
		  NewResourceSetupPage.NavigateToSchedulePageWithCurrentDate();
		  
		  // SELECT ALL BOXES FOR DAVID 
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.SelectRosterDaysForDavid();
		  
		  // CREATE SHIFT REQUIREMENT
		  SchedulerShiftManagementPage.CreateShiftRequirements();
		  
		  // SELECT ALL BOXES FOR ZAC
		  SchedulerShiftManagementPage.SelectRosterDaysForZac();

		  // CREATE ADDITIONAL SHIFT REQUIREMENTS
		  SchedulerShiftManagementPage.CreateAdditionalShiftRequirements();
		  
		  // TEST CASE DONE

		  
	}
}
