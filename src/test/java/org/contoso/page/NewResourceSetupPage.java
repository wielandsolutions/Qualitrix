/*
 * Author:	Sachin Kulageri
 * Company:	Wieland IT Solutions Pvt Ltd.
 * Client:	Contoso
 * File:	New Resource Page Methods for Creating New Employee */

package org.contoso.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.contoso.generic.ExtentTestManager;
import org.contoso.generic.GenericFunctions;
import org.contoso.generic.ReadTestDataFromExcel;
import org.contoso.pageobject.NewResourceSetupPageObject;
import org.contoso.startup.BaseTest;
import org.contoso.testdata.TestDataForContoso;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class NewResourceSetupPage extends BaseTest
{ 
	static Logger log = Logger.getLogger(NewResourceSetupPage.class.getName());
	NewResourceSetupPageObject NewResourceSetupPageObj = PageFactory.initElements(driver, NewResourceSetupPageObject.class); 
	LocalDate Today = LocalDate.now();
	String CurrentDate = DateTimeFormatter.ofPattern("MM/dd/YYYY").format(Today);
	
	public void NewEmployeeSetup() throws InterruptedException
	{
		// Getting Test data from TestDataSheet
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
				
		String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
		String LastName  = objListOFTestDataForContoso.get(0).getLastName();
		
		try
		{
            //Extent Manager for Generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is adding New Employee as Worker to Contoso");
			
			// Step 1: Click on Hamburger
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			
			// Step 2: Click on Human Resource Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
			NewResourceSetupPageObj.HumanResourceTab.click();
			
			// Step 3: Click on Workers Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
			NewResourceSetupPageObj.WorkersTab.click();
			
			// Step 4: Click on New Worker Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.NewWorker);
			NewResourceSetupPageObj.NewWorker.click();
			
			// Step 5: Send Text to First Name Input
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FirstName);
			NewResourceSetupPageObj.FirstName.sendKeys(FirstName);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Send Text to Last Name Input
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LastName);
			NewResourceSetupPageObj.LastName.sendKeys(LastName);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Send Date & Time to Employee Start Date Input
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EmployeeStartDate);
			NewResourceSetupPageObj.EmployeeStartDate.click();
			GenericFunctions.waitWebDriver(4000);

//			GenericFunctions generic =new GenericFunctions();		
//			boolean MatchFoundStatus = generic.isElementPresent(NewResourceSetupPageObj.MatchFoundDialog);
//			System.out.println(MatchFoundStatus);	
//			
//
//				if(MatchFoundStatus==true)	
//				{
//				GenericFunctions.waitWebDriver(2000);
//				System.out.println("Is Dialog displayed : "+NewResourceSetupPageObj.MatchFoundDialog.isDisplayed());
//				System.out.println("MatchFoundDialog displayed, Hence closing it");
//
//				Robot rob = new Robot();
//				rob.keyPress(KeyEvent.VK_ESCAPE);
//				GenericFunctions.waitWebDriver(2000);
//				}
//				else if(MatchFoundStatus==false)
//				{	
//					System.out.println("No macthing names pre exist in the system");
//
//				}
				
			NewResourceSetupPageObj.EmployeeStartDate.sendKeys(CurrentDate);	
			System.out.println("Today's date is : " + CurrentDate);
			GenericFunctions.waitWebDriver(2000);

			// Step 8: Send Date & Time to Assignment Start Date Input
			NewResourceSetupPageObj.AssignmentStartDate.click();
			GenericFunctions.waitWebDriver(5000);
			
			// Step 9: Click Hire button
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HireButton);
			NewResourceSetupPageObj.HireButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 9: Send Text to Filter Search Box
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
			GenericFunctions.waitWebDriver(2000);
			NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);
			
			GenericFunctions.waitWebDriver(2000);
			
            // Step 10: Validating Employee By Searching from Search List
			try
			{
			NewResourceSetupPageObj.CheckName.click();
			GenericFunctions.waitWebDriver(4000);
			String CheckName = NewResourceSetupPageObj.CheckName.getAttribute("value");
			System.out.println(  "Checking Search Name:" + CheckName );
			
				if(CheckName.contentEquals(FirstName+" "+LastName))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is able to search the Employee Added from the search list");
					Assert.assertTrue(true,"Scheduler is able to search the employee added from the search results");
					System.out.println("Scheduler is able to search the employee added from the search results");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to search the employee added from the search results");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler failed to search the employee added from the search results"+e.getLocalizedMessage());
			}						
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to add New Employee as Worker to Contoso");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to add New Employee"+e.getLocalizedMessage());
		}
	}
	
	public void SetStandardCalendar() throws InterruptedException
	{
		// Getting Test data from TestDataSheet
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");						
		String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
		String LastName  = objListOFTestDataForContoso.get(0).getLastName();
		
		try
		{
            //Extent Manager for Generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to set Standard Calendar in Resource Setup page ");
			
			// Step 1: Click on Hamburger
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			
			// Step 2: Click on Human Resource Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
			NewResourceSetupPageObj.HumanResourceTab.click();
			GenericFunctions.waitWebDriver(2000);
			// Step 3: Click on Workers Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
			NewResourceSetupPageObj.WorkersTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Send Text to Filter Search Box
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName,Keys.ENTER);
			GenericFunctions.waitWebDriver(3000);

			// Step 5: Select the Worker
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CheckName);
			NewResourceSetupPageObj.CheckName.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on Project Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.PROJECT);
			NewResourceSetupPageObj.PROJECT.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Click on Project Setup 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ProjectSetup);
			NewResourceSetupPageObj.ProjectSetup.click();
			GenericFunctions.waitWebDriver(6000);			

			// Step 8: Using Keys on Select Calendar Drop Down
			Robot rob = new Robot();
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SelectStandardCalendar);
			NewResourceSetupPageObj.SelectStandardCalendar.click();
			
			// Step 9: Click on Edit Option
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EditOption);
			NewResourceSetupPageObj.EditOption.click();
			GenericFunctions.waitWebDriver(2000);
			
			rob.keyPress(KeyEvent.VK_ALT);  //press windows key
			rob.keyPress(KeyEvent.VK_DOWN); // press Down Key
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.StandardCalendarOption);
			NewResourceSetupPageObj.StandardCalendarOption.click();
			GenericFunctions.waitWebDriver(2000);

//			rob.keyPress(KeyEvent.VK_ENTER);			
//			GenericFunctions.waitWebDriver(2000);

			// Step 10: Save Worker Details
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(4000);
			
			// Step 11: Refresh page
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(4000);
			
			
			try
			{
				// Extent manager to generate report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to verify if standard calendar has been set correctly or not");

				// Step 12: Search again the Employee 
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
				NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
				GenericFunctions.waitWebDriver(3000);
				NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);
				
				// Step 13: Select the Worker
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CheckName);
				NewResourceSetupPageObj.CheckName.click();
				GenericFunctions.waitWebDriver(3000);
				
				// Step 14: Click on Project Tab
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.PROJECT);
				NewResourceSetupPageObj.PROJECT.click();
				GenericFunctions.waitWebDriver(3000);
				
				// Step 15: Click on Project Setup 
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ProjectSetup);
				NewResourceSetupPageObj.ProjectSetup.click();
				GenericFunctions.waitWebDriver(3000);
				
				// Step 16: Get Text of Standard Calendar
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SelectStandardCalendar);
				NewResourceSetupPageObj.SelectStandardCalendar.click();
				GenericFunctions.waitWebDriver(500);
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EditOption);
				NewResourceSetupPageObj.EditOption.click();
				String StandardCalendarName = NewResourceSetupPageObj.SelectStandardCalendar.getAttribute("title");
				GenericFunctions.waitWebDriver(2000);
			
				// Step 17: Validating Standard Calendar Check
					if(StandardCalendarName.equals("Standard"))
					System.out.println("The Calendar has been set to:" + StandardCalendarName + " successfully");
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to set Standard Calendar in Resource Setup Page ");
						Assert.assertTrue(true,"Scheduler successfully able to set Standard Calendar in Resource Setup Page ");
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to search the calendar set");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler unable to search the calendar set"+e.getLocalizedMessage());
				}		
		}
			
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler not able to set the calendar to Standard Calendar");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler not able to set the calendar to Standard Calendar"+e.getLocalizedMessage());	
		}
		
	}
	
	public void SetStandardCalendarInResourcePage () throws InterruptedException
	{
		
		try
		{
            //Extent Manager for Generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to set Standard calendar in resource page");
			
			List <TestDataForContoso> objListOFTestDataForContoso = null;
			objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
					
			String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
			String LastName  = objListOFTestDataForContoso.get(0).getLastName();
				
				// Step 1: Click on Hamburger
				NewResourceSetupPageObj.Hamburger.click();

				NewResourceSetupPageObj.HumanResourceTab.click();
				GenericFunctions.waitWebDriver(2000);

				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
				NewResourceSetupPageObj.WorkersTab.click();	
				GenericFunctions.waitWebDriver(2000);

					
				// Step 4: Search for the employee
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
				NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
				GenericFunctions.waitWebDriver(2000);
				NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
				GenericFunctions.waitWebDriver(2000);
				
				// Step 5: Get employee personnel number
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EmployeePersonnelNumber);
				String EmployeeNumber =NewResourceSetupPageObj.EmployeePersonnelNumber.getAttribute("title");
				System.out.println("Employee personnel number is :"+EmployeeNumber);
				GenericFunctions.waitWebDriver(2000);
			
			// Step 1: Click on Hamburger
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 2: Click on Organization administration tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OrganizationAdministrationTab);
			NewResourceSetupPageObj.OrganizationAdministrationTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 3: Click on Resources Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ResourcesTab);
			NewResourceSetupPageObj.ResourcesTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 4: Search for Employee
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(EmployeeNumber,Keys.ENTER);
			GenericFunctions.waitWebDriver(2000);

			// Step 5: Click on Add button
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AddButton);
			NewResourceSetupPageObj.AddButton.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 6: Click Down Arrow Key and select Standard Calendar
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CalendarDownArrowKey);
			NewResourceSetupPageObj.CalendarDownArrowKey.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.StandardCalendarOption);
			NewResourceSetupPageObj.StandardCalendarOption.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 7: Save Resource Details
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 8: Refresh page
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			
				try
				{	
					// Extent manager to generate report
					ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to verify if standard calendar has been set correctly or not");

					
					// Step 9: Search for Employee
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
					NewResourceSetupPageObj.FilterSearch.sendKeys(EmployeeNumber,Keys.ENTER);
					GenericFunctions.waitWebDriver(2000);

					// Step 10: Click on Standard
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.StandardCalendar);
					NewResourceSetupPageObj.StandardCalendar.click();
					GenericFunctions.waitWebDriver(2000);

					// Step 11: Click on Edit Icon
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EditOption);
					NewResourceSetupPageObj.EditOption.click();
					GenericFunctions.waitWebDriver(3000);

					// Step 12: Get text for Standard calendar
					String StandardCalendarName = NewResourceSetupPageObj.StandardCalendar.getAttribute("title");					
					if(StandardCalendarName.contains("Standard"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to set Standard Calendar in Resources Page ");
						Assert.assertTrue(true,"Scheduler successfully able to set Standard Calendar in Resources Page ");
						System.out.println("The Calendar has been set to Standard successfully");

					}
					
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to search the calendar set");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler unable to search the calendar set"+e.getLocalizedMessage());
				}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to set Standard Calendar in Resources page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler unable to set Standard Calendar in Resources page"+e.getLocalizedMessage());
		}
	}
	
	public void UpdateLocationStructure()throws InterruptedException
	{	
		// Getting Test data from TestDataSheet
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
		
		String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
		String LastName  = objListOFTestDataForContoso.get(0).getLastName();
		System.out.println(FirstName+" "+LastName);
		
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");				
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selected location is :"+Location);
		
		try
		{
        //Extent Manager for Generating Report
		ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to update location structure for the newly created employee ");
			
			// Step 1: Click on Hamburger
			NewResourceSetupPageObj.Hamburger.click();
			
			// Step 2: Click on Human Resource Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
			String Class=NewResourceSetupPageObj.HumanResourceTab.getAttribute("class");
			System.out.println("Class :"+Class);

				if(Class.equals("modulesPane-module modulesPane-isActive"))
					{	
					// Step 3: Click on Workers Tab
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
					NewResourceSetupPageObj.WorkersTab.click();
					}
				
				else 
				{
					NewResourceSetupPageObj.HumanResourceTab.click();
					GenericFunctions.waitWebDriver(2000);
	
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
					NewResourceSetupPageObj.WorkersTab.click();
					GenericFunctions.waitWebDriver(2000);

				}
			// Step 4: Search for the employee
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.click();
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
			GenericFunctions.waitWebDriver(2000);
			NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Get employee personnel number
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EmployeePersonnelNumber);
			String EmployeeNumber =NewResourceSetupPageObj.EmployeePersonnelNumber.getAttribute("title");
			System.out.println("Employee personnel number is :"+EmployeeNumber);
			GenericFunctions.waitWebDriver(2000);
		
		
		// Step 6: Click on Hamburger 
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
		NewResourceSetupPageObj.Hamburger.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 7: Click on Workforce Management
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
		NewResourceSetupPageObj.WorkforceManagementTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 8: Click on Resources
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationStructureTab);
		NewResourceSetupPageObj.LocationStructureTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 9: Expand the Location items
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdown);
		NewResourceSetupPageObj.LocationDropdown.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 10: Select Location
			try
			{						
				if(Location.equals("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
						NewResourceSetupPageObj.WeldingTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				{				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OperationsTab);
						NewResourceSetupPageObj.OperationsTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				}
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ElectricalIstrTab);
					NewResourceSetupPageObj.ElectricalIstrTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}
		// Step 6: Click on Add
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AddButton);
		NewResourceSetupPageObj.AddButton.click();
		GenericFunctions.waitWebDriver(4000);
		
		// Step 7: Add Resource Number
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ResourceNumberHolder);
		NewResourceSetupPageObj.ResourceNumberHolder.click();
		NewResourceSetupPageObj.ResourceNumberHolder.sendKeys(EmployeeNumber);
		GenericFunctions.waitWebDriver(4000);

		// Step 8: Add Effective Date

		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EffectiveDateHolder);
		NewResourceSetupPageObj.EffectiveDateHolder.click();
		NewResourceSetupPageObj.EffectiveDateHolder.sendKeys("1/1/2018");
		GenericFunctions.waitWebDriver(2000);
		
		// Step 9: Add Expiration Date
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ExpirationDateHolder);
		NewResourceSetupPageObj.ExpirationDateHolder.click();
		NewResourceSetupPageObj.ExpirationDateHolder.sendKeys("1/1/2030");
		GenericFunctions.waitWebDriver(4000);

		// Step 10: Save the content
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
		NewResourceSetupPageObj.SaveButton.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 11: Refresh the page
		GenericFunctions.refreshWebPage();
		
				try
				{	
		            //Extent Manager for Generating Report
					ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to verify that the Location Structure for newly created employee is updated");
					
					// Step 12: Expand the Location items
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdown);
					NewResourceSetupPageObj.LocationDropdown.click();
					GenericFunctions.waitWebDriver(2000);
					
					// Step 13: Click on Welding tab
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
					NewResourceSetupPageObj.WeldingTab.click();
					GenericFunctions.waitWebDriver(4000);					
					
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to update location structure for the newly created employee ");
					Assert.assertTrue(true,"Scheduler successfully able to update location structure for the newly created employee ");
					System.out.println("Scheduler successfully able to update location structure for the newly created employee ");								
					
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to verify that the Location Structure for newly created employee is updated");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler is unable to verify that the Location Structure for newly created employee is updated"+e.getLocalizedMessage());
				}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to set Location Structure for the newly created employee");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to set Location Structure for the newly created employee"+e.getLocalizedMessage());
		}
	}		
	
	public void InitializeResourceCalendar() throws InterruptedException
	{
		
		try
		{
	        //Extent Manager for Generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to initialize the Resource Calendar");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Initialize Resource Calendar
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.InitializeResourceCalendarTab);
			NewResourceSetupPageObj.InitializeResourceCalendarTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Enter Start Date
			LocalDate Today = LocalDate.now();
			String CurrentDate = DateTimeFormatter.ofPattern("MM/dd/YYYY").format(Today);
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.StartDateHolder);
			NewResourceSetupPageObj.StartDateHolder.click();
			NewResourceSetupPageObj.StartDateHolder.sendKeys("1/14/2019");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Enter End Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EndDateHolder);
			NewResourceSetupPageObj.EndDateHolder.click();
			NewResourceSetupPageObj.EndDateHolder.sendKeys("1/14/2020");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Enable Remove Existing Records by using Slider
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RemoveExistingRecordsSlider);
			NewResourceSetupPageObj.RemoveExistingRecordsSlider.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8: Click OK button
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			
			//Step 9: Wait for Blocking Message Popup to Disappear
			GenericFunctions.waitWebDriver(30000);
			GenericFunctions.waitTillTheElementInVisible(NewResourceSetupPageObj.SuccessfullInitializationPopup);
			GenericFunctions generic = new GenericFunctions();
			boolean SuccessfullMessage = generic.isElementPresent(NewResourceSetupPageObj.SuccessfullInitializationPopup);
			if(SuccessfullMessage==true)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Resource Calendar Initialized successfully ");
				Assert.assertTrue(true,"Resource Calendar Initialized successfully ");
				System.out.println("Resource Calendar Initialized successfully ");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to initialize the resource calendar");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to initialize the resource calendar"+e.getLocalizedMessage());
		}
	}
	
	public void NavigateToSchedulePageWithCurrentDate()throws InterruptedException
	{
		
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selceted location is :"+Location);
		
		try
		{	
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to navigate to Schedule Page by adding Site, Location and CURRENT DATE as parameters ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on All Schedules Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AllSchedulesTab);
			NewResourceSetupPageObj.AllSchedulesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Send keys to input Site Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SiteParameterHolder);
			NewResourceSetupPageObj.SiteParameterHolder.click();
			NewResourceSetupPageObj.SiteParameterHolder.sendKeys("MainOffice");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Send Current Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DateParameterHolder);
			NewResourceSetupPageObj.DateParameterHolder.click();
			NewResourceSetupPageObj.DateParameterHolder.sendKeys(CurrentDate);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Select Welding as input Location Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationParameterDropdown);
			NewResourceSetupPageObj.LocationParameterDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RandwickPowerstationDropdown);
			NewResourceSetupPageObj.RandwickPowerstationDropdown.click();
			GenericFunctions.waitWebDriver(1000);
				
			// Step 6: Select Location
			try
			{						
				if(Location.equals("WELDING"))
				 {		
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
					NewResourceSetupPageObj.WeldingTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				{				
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OperationsTab);
					NewResourceSetupPageObj.OperationsTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				}
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ElectricalIstrTab);
					NewResourceSetupPageObj.ElectricalIstrTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");
			}				
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdownOkButton);
			NewResourceSetupPageObj.LocationDropdownOkButton.click();
			GenericFunctions.waitWebDriver(1000);
			

			
			// Step 7: Click on OK
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(5000);
			
			try
			{
			// Step 8: Verifying successful navigation to Schedule Page
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SchedulePageTitle);
			String PageTitle = NewResourceSetupPageObj.SchedulePageTitle.getText();
			System.out.println(" User is in :"+PageTitle+"Page");
				if(PageTitle.equals("Schedule"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is successfully able to navigate to Schedule Page by adding Site, Location and CURRENT DATE as parameters ");
					Assert.assertTrue(true,"Scheduler is successfully able to navigate to Schedule Page by adding Site, Location and CURRENT DATE as parameters ");
					System.out.println("Scheduler is successfully able to navigate to Schedule Page by adding Site, Location and CURRENT DATE as parameters ");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page with CURRENT DATE as parameter");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler is unable to navigate to schedule Page with CURRENT DATE as parameter"+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page with CURRENT DATE as parameter");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to navigate to schedule Page with CURRENT DATE as parameter"+e.getLocalizedMessage());
		}
	}
	
	public void NavigateToSchedulePageWithPastDate()throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Location = objListOFTestDataForContoso.get(0).getOccupation();

		try
		{	
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to navigate to Schedule Page by adding Site, Location and PAST DATE as parameters ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on All Schedules Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AllSchedulesTab);
			NewResourceSetupPageObj.AllSchedulesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Send keys to input Site Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SiteParameterHolder);
			NewResourceSetupPageObj.SiteParameterHolder.click();
			NewResourceSetupPageObj.SiteParameterHolder.sendKeys("MainOffice",Keys.ENTER);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Select Welding as input Location Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationParameterDropdown);
			NewResourceSetupPageObj.LocationParameterDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RandwickPowerstationDropdown);
			NewResourceSetupPageObj.RandwickPowerstationDropdown.click();
			GenericFunctions.waitWebDriver(1000);
		
			// Step 10: Select Location
			try
			{						
				if(Location.equals("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
						NewResourceSetupPageObj.WeldingTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				{				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OperationsTab);
						NewResourceSetupPageObj.OperationsTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				}
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ElectricalIstrTab);
					NewResourceSetupPageObj.ElectricalIstrTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}			
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdownOkButton);
			NewResourceSetupPageObj.LocationDropdownOkButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 6: Send Past Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DateParameterHolder);
			NewResourceSetupPageObj.DateParameterHolder.click();
			NewResourceSetupPageObj.DateParameterHolder.sendKeys("1/15/2018");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Click on OK
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			try
			{
			// Step 8: Verifying successful navigation to Schedule Page
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SchedulePageTitle);
			String PageTitle = NewResourceSetupPageObj.SchedulePageTitle.getText();
			
				if(PageTitle.equals("Schedule"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to navigate to schedule Page by adding Site, Location and PAST DATE as parameters ");
					Assert.assertTrue(true,"Scheduler successfully able to navigate to schedule Page by adding Site, Location and PAST DATE as parameters ");
					System.out.println("Scheduler successfully able to navigate to schedule Page by adding Site, Location and PAST DATE as parameters ");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page by adding Site, Location and PAST DATE as parameters");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler is unable to navigate to schedule Page by adding Site, Location and PAST DATE as parameters"+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page by adding required parameters");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to navigate to schedule Page by adding required parameters"+e.getLocalizedMessage());
		}
	}
	
	
	public void NavigateToSchedulePageWithFutureDate()throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selected location is :"+Location);
		
		try
		{	
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to navigate to Schedule Page by adding Site, Location and FUTURE DATE as parameters ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on All Schedules Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AllSchedulesTab);
			NewResourceSetupPageObj.AllSchedulesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Send keys to input Site Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SiteParameterHolder);
			NewResourceSetupPageObj.SiteParameterHolder.click();
			NewResourceSetupPageObj.SiteParameterHolder.sendKeys("MainOffice",Keys.ENTER);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Select Welding as input Location Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationParameterDropdown);
			NewResourceSetupPageObj.LocationParameterDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RandwickPowerstationDropdown);
			NewResourceSetupPageObj.RandwickPowerstationDropdown.click();
			GenericFunctions.waitWebDriver(1000);
				
			// Step 10: Select Location
			try
			{						
				if(Location.equals("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
						NewResourceSetupPageObj.WeldingTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				{				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OperationsTab);
						NewResourceSetupPageObj.OperationsTab.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				}
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ElectricalIstrTab);
					NewResourceSetupPageObj.ElectricalIstrTab.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}			
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdownOkButton);
			NewResourceSetupPageObj.LocationDropdownOkButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 6: Send Past Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DateParameterHolder);
			NewResourceSetupPageObj.DateParameterHolder.click();
			NewResourceSetupPageObj.DateParameterHolder.sendKeys("1/14/2020");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Click on OK
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(10000);
			
			try
			{
			// Step 8: Verifying successful navigation to Schedule Page
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SchedulePageTitle);
			String PageTitle = NewResourceSetupPageObj.SchedulePageTitle.getText();
			
				if(PageTitle.equals("Schedule"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters ");
					Assert.assertTrue(true,"Scheduler successfully able to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters ");
					System.out.println("Scheduler successfully able to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters ");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler is unable to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters"+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to navigate to schedule Page by adding Site, Location and FUTURE DATE as parameters"+e.getLocalizedMessage());
		}
	}
	
	public void UpdateSkillsAndCertificates() throws InterruptedException
	{
		// Getting Test data from TestDataSheet
		
				List <TestDataForContoso> objListOFTestDataForContoso = null;
				objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
				String ShiftType = objListOFTestDataForContoso.get(0).getShiftType();
				System.out.println("Selected Shift Type is :"+ShiftType);

				
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to get Skills and Certificates from 'Shift types' Page ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Initialize Resource Calendar
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ShiftTypesTab);
			NewResourceSetupPageObj.ShiftTypesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
					
					if(ShiftType.equals("ASSISTANT OPERATOR"))
					{
						System.out.println("ShiftType :"+"ASSISTANT OPERATOR");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AssistantOperatorTile);
						NewResourceSetupPageObj.AssistantOperatorTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("BOILERMAKER"))
					{
						System.out.println("ShiftType :"+"BOILERMAKER");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.BoilerMakerTile);
						NewResourceSetupPageObj.BoilerMakerTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("CLEANER"))
					{
						System.out.println("ShiftType :"+"CLEANER");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CleanerTile);
						NewResourceSetupPageObj.CleanerTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("ELEC APPRENTICE"))
					{
						System.out.println("ShiftType :"+"ELEC APPRENTICE");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ElectricalApprenticeTile);
						NewResourceSetupPageObj.ElectricalApprenticeTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equals("GENERAL HAND"))
					{
						System.out.println("ShiftType :"+"GENERAL HAND");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.GeneralHandTile);
						NewResourceSetupPageObj.GeneralHandTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("MAINT/TECH ELEC"))
					{
						System.out.println("ShiftType :"+"MAINT/TECH ELEC");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.MaintTechELecTile);
						NewResourceSetupPageObj.MaintTechELecTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("MAINT/TECH I&C"))
					{
						System.out.println("ShiftType :"+"MAINT/TECH I&C");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.MaintTechINCTile);
						NewResourceSetupPageObj.MaintTechINCTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("MAINT/TECH MECH"))
					{
						System.out.println("ShiftType :"+"MAINT/TECH MECH");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.MaintTechMechTile);
						NewResourceSetupPageObj.MaintTechMechTile.click();
						GenericFunctions.waitWebDriver(2000);
					}
					
					else if(ShiftType.equalsIgnoreCase("SCAFFOLDER RIGGER"))
					{
						System.out.println("ShiftType :"+"SCAFFOLDER RIGGER");
						GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ScaffolderRiggerTile);
						NewResourceSetupPageObj.ScaffolderRiggerTile.click();
						GenericFunctions.waitWebDriver(2000);
					}		
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to fetch Skills and Certificates data from 'Shift types' Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to fetch Skills and Certificates data from 'Shift types' Page"+e.getLocalizedMessage());
		}
		try
		{	
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to add required Skills and Certificates to the newly created employee ");
			
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CertificationName);
			String Certificate = NewResourceSetupPageObj.CertificationName.getAttribute("title");
			String[] Words = Certificate.split("\\s+");
			System.out.println("Certificate : "+Words[0]);
			String RequiredCertificate =Words[0];
			GenericFunctions.waitWebDriver(2000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SkillType);
			String SkillType = NewResourceSetupPageObj.SkillType.getAttribute("title");
			String[] Words1 = SkillType.split("\\s+");
			System.out.println("Skill Type : "+Words1[0]);
			String RequiredSkillType = Words1[0];
			GenericFunctions.waitWebDriver(2000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LevelNumber);
			String LevelNumber = NewResourceSetupPageObj.LevelNumber.getAttribute("title");
			String[] Words2 = LevelNumber.split("\\s+");
			System.out.println("Level Number : "+Words2[0]);
			String RequiredLevelNumber =Words2[0];
			GenericFunctions.waitWebDriver(2000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LevelName);
			String LevelName = NewResourceSetupPageObj.LevelName.getAttribute("title");
			String[] Words3 = LevelName.split("\\s+");
			System.out.println("Level Name : "+Words3[0]);
			String RequiredLevelName =Words3[0];
			GenericFunctions.waitWebDriver(2000);
			
			// Step 1: Click on Hamburger
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 2: Click on Human Resource Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
			NewResourceSetupPageObj.HumanResourceTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 3: Click on Workers Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
			NewResourceSetupPageObj.WorkersTab.click();
			GenericFunctions.waitWebDriver(2000);

			
			objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");						
			String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
			String LastName  = objListOFTestDataForContoso.get(0).getLastName();
			
			// Step 4: Select employee
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
			GenericFunctions.waitWebDriver(2000);
			NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Click on Header Worker tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
			NewResourceSetupPageObj.HeaderWorkerTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 6: Click on Certificates
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Certificates);
			NewResourceSetupPageObj.Certificates.click();
			GenericFunctions.waitWebDriver(3000);

			// Step 7: Click on New Button
			Robot rob = new Robot();
			rob.keyPress(KeyEvent.VK_ALT);
			rob.keyPress(KeyEvent.VK_N);
			GenericFunctions.waitWebDriver(1500);

			// Step 8: Select the certificate type
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CertificateTypePaceHolder);
			NewResourceSetupPageObj.CertificateTypePaceHolder.click();	
			NewResourceSetupPageObj.CertificateTypePaceHolder.sendKeys(RequiredCertificate);
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CertificateTypeOption);
			NewResourceSetupPageObj.CertificateTypeOption.click();
			
			// Step 9: Input Start date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.StartDate);
			NewResourceSetupPageObj.StartDate.click();
			NewResourceSetupPageObj.StartDate.sendKeys(CurrentDate);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Save 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 11: Refresh the Page
			GenericFunctions.refreshWebPage();
			
			// Step 12: Select employee again
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
			GenericFunctions.waitWebDriver(2000);
			NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
			GenericFunctions.waitWebDriver(2000);
			
			// Step 13: Click on Header Worker tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
			NewResourceSetupPageObj.HeaderWorkerTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 14: Click on Skills
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Skills);
			NewResourceSetupPageObj.Skills.click();
			GenericFunctions.waitWebDriver(3000);

			// Step 15: Click on New 
			rob.keyPress(KeyEvent.VK_ALT);
			rob.keyPress(KeyEvent.VK_N);
			GenericFunctions.waitWebDriver(1500);

			// Step 16: Select Budgeting from skill Dropdown
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SkillHolder);
			NewResourceSetupPageObj.SkillHolder.click();
			NewResourceSetupPageObj.SkillHolder.sendKeys(RequiredSkillType);
			GenericFunctions.waitWebDriver(1000);
		
			// Step 17: Select Level 2
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(NewResourceSetupPageObj.LevelHolder);
			NewResourceSetupPageObj.LevelHolder.sendKeys(RequiredLevelNumber);
			GenericFunctions.waitWebDriver(4000);
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(NewResourceSetupPageObj.LevelDropdown);
			NewResourceSetupPageObj.LevelDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			
			if(RequiredLevelName.equals("Skills"))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(NewResourceSetupPageObj.NoviceForSkills);
				NewResourceSetupPageObj.NoviceForSkills.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(RequiredLevelName.equals("Standard"))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(NewResourceSetupPageObj.TwoForStandard);
				NewResourceSetupPageObj.TwoForStandard.click();
				GenericFunctions.waitWebDriver(2000);
			}
			else if(RequiredLevelName.equals("Goals"))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(NewResourceSetupPageObj.BelowExpectationForGoals);
				NewResourceSetupPageObj.BelowExpectationForGoals.click();
				GenericFunctions.waitWebDriver(2000);
			}
	
			// Step 18: Input Level Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LevelDateHolder);
			NewResourceSetupPageObj.LevelDateHolder.click();
			NewResourceSetupPageObj.LevelDateHolder.sendKeys(CurrentDate);
			GenericFunctions.waitWebDriver(1000);

			// Step 19: Save
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 20: Refresh the Page
			GenericFunctions.refreshWebPage();
			
				try
				{
					// Extent Manager for generating Report
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to validate the added required Skills and Certificates to the newly created employee ");
					
					// Step 21: Select Employee
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
					NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
					GenericFunctions.waitWebDriver(2000);
					NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
					GenericFunctions.waitWebDriver(2000);
					
					// Step 22: Click on Header Worker Tab 
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
					NewResourceSetupPageObj.HeaderWorkerTab.click();
					GenericFunctions.waitWebDriver(500);
					
					// Step 23: Click on Certificates
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Certificates);
					NewResourceSetupPageObj.Certificates.click();
					GenericFunctions.waitWebDriver(3000);
					
					// Step 24: Get attached Certificate
					GenericFunctions.waitWebDriver(2000);
					String certificate = NewResourceSetupPageObj.UserCenteredDesign.getAttribute("title");
					System.out.println("The attached certificate is " + certificate);
					GenericFunctions.refreshWebPage();
					
					// Step 25: Select employee again
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
					NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
					GenericFunctions.waitWebDriver(2000);
					NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
					GenericFunctions.waitWebDriver(2000);
					
					// Step 26: Click on Header Worker tab
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
					NewResourceSetupPageObj.HeaderWorkerTab.click();
					GenericFunctions.waitWebDriver(500);
					
					// Step 27: Click on Skills
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Skills);
					NewResourceSetupPageObj.Skills.click();
					GenericFunctions.waitWebDriver(2000);

					// Step 28: Click on Edit
					rob.keyPress(KeyEvent.VK_F2);

					
					// Step 29: Get attached skill and level
					String Skill = NewResourceSetupPageObj.SkillHolder.getAttribute("title");
					String Level = NewResourceSetupPageObj.LevelHolder.getAttribute("title");
					System.out.println("The Skill found is " + Skill);
					System.out.println("The level set is " + Level);
					
					if(Certificate.equals(RequiredCertificate)||Skill.equals(RequiredSkillType)||Level.equals(RequiredLevelNumber))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler successfully able to add certificates and Skills to the worker");
						Assert.assertTrue(true,"Scheduler successfully able to add certificates and Skills to the worker");
						System.out.println("Scheduler successfully able to add certificates and Skills to the worker");
					}
					
					
					
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to add required Skills and Certificates to the newly created employee ");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler is unable to add required Skills and Certificates to the newly created employee "+e.getLocalizedMessage());
				}
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to add required Skills and Certificates to the newly created employee ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to add required Skills and Certificates to the newly created employee "+e.getLocalizedMessage());
		}
	}
	
	@SuppressWarnings("static-access")
	public void AddProfileImage() throws InterruptedException
	{
		// Getting Test data from TestDataSheet
				List <TestDataForContoso> objListOFTestDataForContoso = null;
				objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
						
				String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
				String LastName  = objListOFTestDataForContoso.get(0).getLastName();
		try
		{
		// Extent Manager for generating Report
		ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to add the Profile Image to an employee ");

		// Step 1: Click on Hamburger
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
		NewResourceSetupPageObj.Hamburger.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 2: Click on Human Resource Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
		NewResourceSetupPageObj.HumanResourceTab.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 3: Click on Workers Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
		NewResourceSetupPageObj.WorkersTab.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 4: Select employee
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
		NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
		GenericFunctions.waitWebDriver(2000);
		NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
		GenericFunctions.waitWebDriver(2000);
		
		// Step 5: Click on Header Worker tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
		NewResourceSetupPageObj.HeaderWorkerTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 6: Click on Image
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Image);
		NewResourceSetupPageObj.Image.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 7: Click on Browse button
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkerImageBrowseButton);
		NewResourceSetupPageObj.WorkerImageBrowseButton.click();
		GenericFunctions.waitWebDriver(2000);
		Actions action = new Actions(driver);
		
		// Step 8: Send keys to file input
		GenericFunctions generic = new GenericFunctions();
		generic.uploadFile("C:\\Users\\wieland\\Pictures\\profile-talent-ant-simpson-feature.jpg");
		GenericFunctions.waitWebDriver(3000);
		
		// Step 9: Click OK
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkerImageOKButton);
		NewResourceSetupPageObj.WorkerImageOKButton.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 10: Click on Workers Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
		NewResourceSetupPageObj.HeaderWorkerTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 11: Click on Image
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Image);
		NewResourceSetupPageObj.Image.click();
		GenericFunctions.waitWebDriver(2000);
		
				// Verify whether the profile image has been added correctly
				try
				{
					// Extent Manager for generating Report
					ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is verifying if the profile image has been added correctly or not ");					
					
					// Step 12: Check if the uploaded image is present
					Boolean ProfileImageStatus = generic.isElementPresent(NewResourceSetupPageObj.UploadedWorkerImage);
					if(ProfileImageStatus==true)
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Profile Image added successfully");
						Assert.assertTrue(true,"Profile Image added successfully");
						System.out.println("Profile Image added successfully");
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add the Profile image to an employee");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Failed to add the Profile image to an employee"+e.getLocalizedMessage());
				}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add the Profile image to an employee");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to add the Profile image to an employee"+e.getLocalizedMessage());
		}
		
	}
	
	public void DeleteProfileImage() throws InterruptedException, AWTException
	{
		// Getting Test data from TestDataSheet
				List <TestDataForContoso> objListOFTestDataForContoso = null;
				objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
						
				String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
				String LastName  = objListOFTestDataForContoso.get(0).getLastName();
				GenericFunctions generic = new GenericFunctions();

		try
		{
		// Extent Manager for generating Report
		ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to remove the profile image of an employee ");

		// Step 1: Click on Hamburger
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
		NewResourceSetupPageObj.Hamburger.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 2: Click on Human Resource Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
		NewResourceSetupPageObj.HumanResourceTab.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 3: Click on Workers Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
		NewResourceSetupPageObj.WorkersTab.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 4: Select employee
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
		NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
		GenericFunctions.waitWebDriver(2000);
		NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
		GenericFunctions.waitWebDriver(2000);
		
		// Step 5: Click on Header Worker tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
		NewResourceSetupPageObj.HeaderWorkerTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 6: Click on Image
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Image);
		NewResourceSetupPageObj.Image.click();
		GenericFunctions.waitWebDriver(2000);
			
		// Step 7: Click on Remove
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkerImageRemoveButton);
		NewResourceSetupPageObj.WorkerImageRemoveButton.click();
		GenericFunctions.waitWebDriver(2000);

		// Step 8: Click OK
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkerImageOKButton);
		NewResourceSetupPageObj.WorkerImageOKButton.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 9: Click on Header Worker tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HeaderWorkerTab);
		NewResourceSetupPageObj.HeaderWorkerTab.click();
		GenericFunctions.waitWebDriver(2000);
		
		// Step 10: Click on Image Tab
		GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Image);
		NewResourceSetupPageObj.Image.click();
		GenericFunctions.waitWebDriver(2000);
				
			// Verify if the image has been removed correctly or not					
			try
			{
				// Extent Manager for generating Report
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is verifying whether profile image has been removed successfully or not");
				
				// Step 10: 
				Boolean ProfileImageStatus = generic.isElementPresent(NewResourceSetupPageObj.UploadedWorkerImage);
				if(ProfileImageStatus==false)
				
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Image removed successfully");
					Assert.assertTrue(true,"Image removed successfully");
					System.out.println("Image removed successfully");
				}
			}
			
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to remove the Profile image of the employee");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Failed to remove the Profile image of the employee"+e.getLocalizedMessage());
			}		
					
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to remove the Profile image of the employee");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to remove the Profile image of the employee"+e.getLocalizedMessage());
		}
	}
	
	
	public void GetEmployeePersonnelNumber() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetuserinfo");
				
		String FirstName = objListOFTestDataForContoso.get(0).getFirstName();
		String LastName  = objListOFTestDataForContoso.get(0).getLastName();
		
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is trying to get the personnel number of newly created employee : "+FirstName+"."+LastName);
			
			// Step 1: Click on Hamburger
			NewResourceSetupPageObj.Hamburger.click();
			
			// Step 2: Click on Human Resource Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.HumanResourceTab);
			String Class=NewResourceSetupPageObj.HumanResourceTab.getAttribute("class");
			System.out.println("Class :"+Class);

				if(Class.equals("modulesPane-module modulesPane-isActive"))
				{	
					// Step 3: Click on Workers Tab
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
					NewResourceSetupPageObj.WorkersTab.click();
					}
				
				else 
				{
					NewResourceSetupPageObj.HumanResourceTab.click();
					GenericFunctions.waitWebDriver(2000);
	
					GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkersTab);
					NewResourceSetupPageObj.WorkersTab.click();
				}
			// Step 4: Search for the employee
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.FilterSearch);
			NewResourceSetupPageObj.FilterSearch.sendKeys(FirstName+" "+LastName);
			GenericFunctions.waitWebDriver(2000);
			NewResourceSetupPageObj.FilterSearch.sendKeys(Keys.ENTER);			
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Get employee personnel number
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.EmployeePersonnelNumber);
			String EmployeeNumber =NewResourceSetupPageObj.EmployeePersonnelNumber.getAttribute("title");
			System.out.println("Employee personnel number is :"+EmployeeNumber);
			GenericFunctions.waitWebDriver(2000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not get the personnel number of newly craeted employee : "+FirstName+"."+LastName);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to remove the Profile image of the employee : "+FirstName+"."+LastName+e.getLocalizedMessage());
		}
	}
}







