package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC14_Verify_Shift_Details_CancelAssigned_DeleteUnassigned_Shifts extends BaseTest{

	@Test
	public void TC14_Verify_Shift_Details() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // NAVIGATE TO SCHEDULE PAGE
		  NewResourceSetupPage NewResourceSetupPage = new NewResourceSetupPage();
		  NewResourceSetupPage.NavigateToSchedulePageWithCurrentDate();
		  
		  // CHECK SHIFT DETAILS
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.CheckDetailsCancelAssignedAndDeleteUnassignedShifts();
		  
		  // TEST CASE DONE
	}

}
