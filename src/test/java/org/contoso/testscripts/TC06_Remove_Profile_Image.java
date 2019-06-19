package org.contoso.testscripts;

import java.awt.AWTException;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC06_Remove_Profile_Image extends BaseTest {
	
	@Test
	public void TC06_Delete_Profile_Image() throws InterruptedException, AWTException
	{
	  // LOGIN AS SCHEDULER
	  LoginPage SchedulerLogin = new LoginPage();
	  SchedulerLogin.userLogin(SCHEDULER);
	  
	  // DELETE PROFILE IMAGE
	  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
	  SetUpStandardCalendar.DeleteProfileImage();
	  
	  // TEST CASE DONE
	}
}
