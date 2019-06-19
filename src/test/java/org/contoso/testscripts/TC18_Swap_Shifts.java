package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.WorkerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC18_Swap_Shifts extends BaseTest{

	@Test
	public void TC18_Shift_Swap() throws InterruptedException
	{
		
		  // LOGIN AS WORKER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(WORKER);
		  	  
		  // ACCEPT SHIFTS
		  WorkerShiftManagementPage WorkerShiftManagementPage = new WorkerShiftManagementPage();
		  WorkerShiftManagementPage.RequestForShiftSwap();
		  
		  // LOG OUT
		  SchedulerLogin.UserLogout();
		  
		  // LOGIN AS COWORKER
		  SchedulerLogin.userLogin(COWORKER);
		  
		  // ACCEPT THE SHIFT SWAP AS A COWORKER
		  WorkerShiftManagementPage.AcceptSwapRequestAsaCoworker();
		  
		  // LOG OUT
		  SchedulerLogin.UserLogout();

		  // APPROVE SHIFT SWAP REQUEST AS A MANAGER
		  WorkerShiftManagementPage.AcceptSwapRequestAsaManager();
	}
}
