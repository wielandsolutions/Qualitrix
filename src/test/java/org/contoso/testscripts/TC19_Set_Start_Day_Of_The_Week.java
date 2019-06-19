package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC19_Set_Start_Day_Of_The_Week extends BaseTest{
	@Test
	public void TC19_Set_The_Start_Day() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // SET THES START DAY OF WEEK
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.SetStartDayOfTheWeek();
		  
		  // VERIFY IF THE START DAY IS CHANGED
		  SchedulerShiftManagementPage.VerifyStartDayOfWeek();
		  
		  // TEST CASE DONE
	}
}
