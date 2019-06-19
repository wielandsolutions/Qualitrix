package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.SchedulerShiftManagementPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC20_Set_Monday_As_The_Start_Day_Of_Week extends BaseTest{
	@Test
	public void TC20_SetMondayAsTheWeekStartDay() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // SET THES START DAY OF WEEK
		  SchedulerShiftManagementPage SchedulerShiftManagementPage = new SchedulerShiftManagementPage();
		  SchedulerShiftManagementPage.SetMondayAsTheStartDayOfWeek();
		  
		  // VERIFY IF THE START DAY IS CHANGED
		  SchedulerShiftManagementPage.VerifyIfMondayIsSetBackAsTheStartDay();
		  
		  // TEST CASE DONE
	}
}
