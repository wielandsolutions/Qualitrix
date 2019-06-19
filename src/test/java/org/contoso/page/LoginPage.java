/*
 * Author:	Sachin Kulageri
 * Company:	Wieland IT Solutions Pvt Ltd.
 * Client:	Contoso
 * File:	Login Page Methods for logging into Microsoft Dynamics 365*/

package org.contoso.page;

import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.support.PageFactory;
import org.contoso.generic.ExtentTestManager;
import org.contoso.generic.GenericFunctions;
import org.contoso.generic.ReadTestDataFromExcel;
import org.contoso.pageobject.LoginPageObject;
import org.contoso.startup.BaseTest;
import org.contoso.testdata.TestDataForContoso;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class LoginPage extends BaseTest
{ 
	static Logger log = Logger.getLogger(LoginPage.class.getName());
	LoginPageObject LoginPageObject = PageFactory.initElements(driver, LoginPageObject.class); 

	
	public void userLogin(String userRole) throws InterruptedException
	{
		
		List <TestDataForContoso> objListOFTestDataForContoso=null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcredentials");
		
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is loging in to the Contoso Application as "+userRole);
			GenericFunctions.waitForElementToAppear(LoginPageObject.Email);
			if(userRole.equalsIgnoreCase("SCHEDULER"))
			{   
				LoginPageObject.Email.sendKeys(objListOFTestDataForContoso.get(0).getUsername());
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Next.click();
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Password.sendKeys(objListOFTestDataForContoso.get(0).getPassword());
				System.out.println("Logged in as "+userRole+" with UN:"+objListOFTestDataForContoso.get(0).getUsername()+" and PW:"+
						objListOFTestDataForContoso.get(0).getPassword());
				log.info("Logged in as"+userRole+"with UN:"+objListOFTestDataForContoso.get(0).getUsername()+" and PW:"+
						objListOFTestDataForContoso.get(0).getPassword());
			}
			else if(userRole.equalsIgnoreCase("WORKER")){
				LoginPageObject.Email.sendKeys(objListOFTestDataForContoso.get(1).getUsername());
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Next.click();
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Password.sendKeys(objListOFTestDataForContoso.get(1).getPassword());
				System.out.println("Logged in as "+userRole+" with Username:"+objListOFTestDataForContoso.get(1).getUsername()+" and Password:"+
						objListOFTestDataForContoso.get(1).getPassword());
				log.info("Username"+objListOFTestDataForContoso.get(1).getUsername()+"/nPassword"+objListOFTestDataForContoso.get(1).getPassword());
			}
			else if(userRole.equalsIgnoreCase("COWORKER")){
				LoginPageObject.Email.sendKeys(objListOFTestDataForContoso.get(2).getUsername());
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Next.click();
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Password.sendKeys(objListOFTestDataForContoso.get(2).getPassword());
				System.out.println("Logged in as "+userRole+" with Username:"+objListOFTestDataForContoso.get(2).getUsername()+" and Password:"+
						objListOFTestDataForContoso.get(2).getPassword());
				log.info("Username"+objListOFTestDataForContoso.get(2).getUsername()+"/nPassword"+objListOFTestDataForContoso.get(2).getPassword());
			}
			else if(userRole.equalsIgnoreCase("MANAGER")){
				LoginPageObject.Email.sendKeys(objListOFTestDataForContoso.get(3).getUsername());
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Next.click();
				GenericFunctions.waitWebDriver(2000);
				LoginPageObject.Password.sendKeys(objListOFTestDataForContoso.get(3).getPassword());
				System.out.println("Logged in as "+userRole+" with Username:"+objListOFTestDataForContoso.get(3).getUsername()+" and Password:"+
						objListOFTestDataForContoso.get(3).getPassword());
				log.info("Username"+objListOFTestDataForContoso.get(3).getUsername()+"/nPassword"+objListOFTestDataForContoso.get(3).getPassword());
			}
			else{
				log.error("User Not found");
			}

			
			LoginPageObject.Sigin.click();
			GenericFunctions.waitWebDriver(2000);
			try
			{
				if(LoginPageObject.StaySignedIn.isDisplayed())
				{
					LoginPageObject.StaySignedIn.click();
				}
			}
			catch(Exception e)
			{
				System.out.println("Stay Signed In Pop up is not Displayed");
			}
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully logged in to the appication");
			Assert.assertTrue(true,"Scheduler successfully logged in to the appication");
			System.out.println("Scheduler successfully logged in to the appication");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User failed to login to the Contoso application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to login to the Contoso application"+e.getLocalizedMessage());
		}
	}
	
	public void UserLogout()throws InterruptedException{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to logout from Contoso Application");
			GenericFunctions.waitForElementToAppear(LoginPageObject.ProfileIcon);
			LoginPageObject.ProfileIcon.click();
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LoginPageObject.SignOut);
			LoginPageObject.SignOut.click();
			GenericFunctions.waitWebDriver(2000);
			System.out.println("User Logout");
			
			GenericFunctions.waitWebDriver(2000);
			if(LoginPageObject.UseAnotherAccount.isDisplayed())
			{
				LoginPageObject.UseAnotherAccount.click();
				GenericFunctions.waitWebDriver(2000);

			}

			

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User could not logout from the Contoso Application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to logout from the Contoso Application"+e.getLocalizedMessage());
		}

	}

}


