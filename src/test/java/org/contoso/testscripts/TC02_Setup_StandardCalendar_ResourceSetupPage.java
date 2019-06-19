package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC02_Setup_StandardCalendar_ResourceSetupPage extends BaseTest {
  @Test
  public void TC02_SetUpStandardCalendar() throws Exception {
	  
	 
	  
	  // LOGIN AS SCHEDULER
	  LoginPage SchedulerLogin = new LoginPage();
	  SchedulerLogin.userLogin(SCHEDULER);
	  
	  // SETUP STANDARD CALENDAR
	  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
	  SetUpStandardCalendar.SetStandardCalendar();
	  

	  
	 
	  
	  
  }
}
