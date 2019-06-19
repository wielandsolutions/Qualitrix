package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.WorkerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC16_Reject_Shift_As_A_Worker extends BaseTest{
	@Test
	public void TC16_Reject_Shift() throws InterruptedException
	{
		  // LOGIN AS WORKER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(WORKER);
		  	  
		  // ACCEPT SHIFTS
		  WorkerShiftManagementPage WorkerShiftManagementPage = new WorkerShiftManagementPage();
		  WorkerShiftManagementPage.RejectShift();
		  
		  // TEST CASE DONE
	}
}
