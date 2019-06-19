package org.contoso.testscripts;

import org.contoso.page.LoginPage;
import org.contoso.page.NewResourceSetupPage;
import org.contoso.startup.BaseTest;
import org.testng.annotations.Test;

public class TC04_Add_Certificates_And_Skills extends BaseTest {
	
	@Test
	public void TC04_Add_Certificates_Plus_Skills() throws InterruptedException
	{
		  // LOGIN AS SCHEDULER
		  LoginPage SchedulerLogin = new LoginPage();
		  SchedulerLogin.userLogin(SCHEDULER);
		  
		  // UPDATE SKILLS AND CERTIFICATES
		  NewResourceSetupPage SetUpStandardCalendar = new NewResourceSetupPage();
		  SetUpStandardCalendar.UpdateSkillsAndCertificates();
		  
		  // TEST CASE DONE
	}

}
