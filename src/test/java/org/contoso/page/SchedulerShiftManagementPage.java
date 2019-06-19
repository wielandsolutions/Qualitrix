package org.contoso.page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.formula.functions.Today;
import org.contoso.generic.ExtentTestManager;
import org.contoso.generic.GenericFunctions;
import org.contoso.generic.ReadTestDataFromExcel;
import org.contoso.pageobject.NewResourceSetupPageObject;
import org.contoso.pageobject.SchedulerShiftManagementPageObject;
import org.contoso.startup.BaseTest;
import org.contoso.testdata.TestDataForContoso;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class SchedulerShiftManagementPage extends BaseTest{
	
	
	SchedulerShiftManagementPageObject SchedulerShiftManagementPageObj = PageFactory.initElements(driver, SchedulerShiftManagementPageObject.class); 
	NewResourceSetupPageObject NewResourceSetupPageObj = PageFactory.initElements(driver, NewResourceSetupPageObject.class); 
	LocalDate Today = LocalDate.now();
	String CurrentDate = DateTimeFormatter.ofPattern("MM/dd/YYYY").format(Today);
	
	
	public void CreateShiftRequirements() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso=null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetprofile");
		String Profileone = objListOFTestDataForContoso.get(0).getProfileOne();
		System.out.println("The selected Profile is :"+Profileone);

		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String ShiftType = objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("The selected Shift Type is :"+ShiftType);

		try
		{

			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to create Shift requirements ");
			GenericFunctions generic = new GenericFunctions();
		
			// Step 1: Click on New			
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SchedulePageNewButton);
			SchedulerShiftManagementPageObj.SchedulePageNewButton.click();
			GenericFunctions.waitWebDriver(2000);
					
				// Step 2: Input Shift Type 
				try
				{
					if(ShiftType.equalsIgnoreCase("ASSISTANT OPERATOR"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ASSISTANT OPERATOR");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("BOILERMAKER"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("BOILERMAKER");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("CLEANER"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("CLEANER");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("ELEC APPRENTICE"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ELEC APPRENTICE");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("GENERAL HAND"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ELEC APPRENTICE");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("MAINT/TECH ELEC"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("MAINT/TECH I&C"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("MAINT/TECH MECH"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
					GenericFunctions.waitWebDriver(2000);
					}
					
					if(ShiftType.equalsIgnoreCase("SCAFFOLDER RIGGER"))
					{
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
					SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
					GenericFunctions.waitWebDriver(2000);
					}
					
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not fetch details from excel sheet");
					System.out.println("Could not fetch details from excel sheet");
	
				}

				try
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is fetch profile data from excelsheet");
					if(Profileone.equalsIgnoreCase("AFTERNOONS"))
					{
						// Step 4: Input Profile
						GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
						SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("AFTERNOONS");
						GenericFunctions.waitWebDriver(4000);
					}
					
				   else if(Profileone.equalsIgnoreCase("DAY"))
					{
						// Step 4: Input Profile
						GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
						SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("DAY");
						GenericFunctions.waitWebDriver(4000);
					}
					
				   else if(Profileone.equalsIgnoreCase("MORNINGS"))
					{
						// Step 4: Input Profile
						GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
						SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("MORNINGS");
						GenericFunctions.waitWebDriver(4000);
					}
					
					else if(Profileone.equalsIgnoreCase("NIGHTS"))
					{
						// Step 4: Input Profile
						GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
						SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("NIGHTS");
						GenericFunctions.waitWebDriver(4000);
					}
					else if(Profileone.equalsIgnoreCase("WEEKEND DAYS"))
					{
						// Step 4: Input Profile
						GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
						SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("WEEKEND DAYS");
						GenericFunctions.waitWebDriver(4000);
					}
					
					
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to fetch profile data from excelsheet");
					System.out.println("Scheduler failed to fetch profile data from excelsheet");
				}
			

			// Step 6: Input Instructions
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.InstructionHolder);
			SchedulerShiftManagementPageObj.InstructionHolder.sendKeys("This is Note");
			GenericFunctions.waitWebDriver(2000);

			// Step 7: Click on OK button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.OkButton);
			SchedulerShiftManagementPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(10000);								
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Morning Shifts created and assigned successfully to David ");
			Assert.assertTrue(true, "Morning Shifts created and assigned successfully to David ");
			System.out.println("Morning Shifts created and assigned successfully to David ");			

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to create and assign Morning Shifts to David");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler unable to create and assign Morning Shifts to David"+e.getLocalizedMessage());
		}
	}
	
	public void CreateAdditionalShiftRequirements() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso=null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String ShiftType = objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("The selected Shift Type is"+ShiftType);
		
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetprofile");
		String Profiletwo = objListOFTestDataForContoso.get(0).getProfileTwo();
		System.out.println("The selected Profile is :"+Profiletwo);
		
		
		try
		{

			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to create Shift requirements for the After noon profile");
			GenericFunctions generic = new GenericFunctions();
		
			// Step 1: Click on New			
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SchedulePageNewButton);
			SchedulerShiftManagementPageObj.SchedulePageNewButton.click();
			GenericFunctions.waitWebDriver(2000);
					
			// Step 2: Input Shift Type 
			try
			{
				if(ShiftType.equalsIgnoreCase("ASSISTANT OPERATOR"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ASSISTANT OPERATOR");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("BOILERMAKER"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("BOILERMAKER");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("CLEANER"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("CLEANER");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("ELEC APPRENTICE"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ELEC APPRENTICE");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("GENERAL HAND"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("ELEC APPRENTICE");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("MAINT/TECH ELEC"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("MAINT/TECH I&C"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("MAINT/TECH MECH"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
				GenericFunctions.waitWebDriver(2000);
				}
				
				if(ShiftType.equalsIgnoreCase("SCAFFOLDER RIGGER"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftTypePlaceHolder);
				SchedulerShiftManagementPageObj.ShiftTypePlaceHolder.sendKeys("MAINT/TECH ELEC");
				GenericFunctions.waitWebDriver(2000);
				}
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not fetch details from excel sheet");
				System.out.println("Could not fetch details from excel sheet");

			}
			
			// Step 4: Input Profile
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);

			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is fetch profile data from excelsheet");
				if(Profiletwo.equalsIgnoreCase("AFTERNOONS"))
				{
					// Step 4: Input Profile
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
					SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("AFTERNOONS");
					GenericFunctions.waitWebDriver(4000);
				}
				
			   else if(Profiletwo.equalsIgnoreCase("DAY"))
				{
					// Step 4: Input Profile
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
					SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("DAY");
					GenericFunctions.waitWebDriver(4000);
				}
				
			   else if(Profiletwo.equalsIgnoreCase("MORNINGS"))
				{
					// Step 4: Input Profile
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
					SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("MORNINGS");
					GenericFunctions.waitWebDriver(4000);
				}
				
				else if(Profiletwo.equalsIgnoreCase("NIGHTS"))
				{
					// Step 4: Input Profile
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
					SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("NIGHTS");
					GenericFunctions.waitWebDriver(4000);
				}
				else if(Profiletwo.equalsIgnoreCase("WEEKEND DAYS"))
				{
					// Step 4: Input Profile
					GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ProfilePlaceHolder);
					SchedulerShiftManagementPageObj.ProfilePlaceHolder.sendKeys("WEEKEND DAYS");
					GenericFunctions.waitWebDriver(4000);
				}
				
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to fetch profile data from excelsheet");
				System.out.println("Scheduler failed to fetch profile data from excelsheet");
			}

			// Step 6: Input Instructions
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.InstructionHolder);
			SchedulerShiftManagementPageObj.InstructionHolder.sendKeys("This is Note");
			GenericFunctions.waitWebDriver(2000);

			// Step 7: Click on OK button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.OkButton);
			SchedulerShiftManagementPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(5000);			
			
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shifts created and assigned successfully for theafternoon profile");
			Assert.assertTrue(true, "Shifts created and assigned successfully for theafternoon profile");
			System.out.println("Shifts created and assigned successfully for theafternoon profile");
					

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to create Shift Requirements for the next day");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler unable to create Shift Requirements for the next day"+e.getLocalizedMessage());
		}
	}
	
	public void AssignShiftsManually() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to assign the shifts manually ");
			
			// Step 1: Minimize Shifts Section
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Check the first required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Click on Unassigned Shifts Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 5: Check the first Shift check box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftCheckbox);
			SchedulerShiftManagementPageObj.FirstShiftCheckbox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on Assign
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.AssignButton);
			SchedulerShiftManagementPageObj.AssignButton.click();
			GenericFunctions.waitWebDriver(4000);
		
			// Step 7: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(5000);
			
			// Step 2: Check the first required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Click on Unassigned Shifts Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 5: Check the first Shift check box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftCheckbox);
			SchedulerShiftManagementPageObj.FirstShiftCheckbox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on Assign
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.AssignButton);
			SchedulerShiftManagementPageObj.AssignButton.click();
			GenericFunctions.waitWebDriver(4000);
					
			// Step 8: Verify if the shift has been assigned to the corresponding selected box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			String AreaValueText1 = SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.getAttribute("aria-valuetext");
			System.out.println(AreaValueText1);
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox);
			String AreaValueText2 = SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.getAttribute("aria-valuetext");
			System.out.println(AreaValueText2);
			
			
			if(AreaValueText1.equals("Created")||AreaValueText2.equals("Created"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Successfully assigned the shifts manually");
				Assert.assertTrue(true, "Successfully assigned the shifts manually");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to assign the shifts manually");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to assign the shifts manually"+e.getLocalizedMessage());
		}
	}
	
	public void AutoAssignShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to auto assign shifts");
			
			// Step 1: Click on Unassigned section Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 2: Select all Shifts
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox);
			SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 3 : Click on AutoAssign Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.AutoAssignTab);
			SchedulerShiftManagementPageObj.AutoAssignTab.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 4 : Click on Shifts Section Page Arrow
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(5000);
			
			
						

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to auto assign the shifst");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to auto assign the shifst"+e.getLocalizedMessage());
		}
	}
	
	public void CheckDetailsCancelAssignedAndDeleteUnassignedShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to verify the shift details");
			
			// Step 1: Minimize Shifts Section 
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(4000);
			
			// Step 2: Click on  David Pelton's profile Image
			GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			GenericFunctions.waitWebDriver(1000);
			SchedulerShiftManagementPageObj.DavidPeltonProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3 : Deselect saturday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonSaturday);
			SchedulerShiftManagementPageObj.DavidPeltonSaturday.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 4 : Deselect sunday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonSunday);
			SchedulerShiftManagementPageObj.DavidPeltonSunday.click();
			GenericFunctions.waitWebDriver(3000);
				
			// Step 4: Click on Header Shift
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 5: Go to Shift details Section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(3000);
			String title1 = SchedulerShiftManagementPageObj.FirstShiftDetails.getAttribute("title");
			System.out.println(title1);

			// Step 6: Click on Header Shift
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 7: Unselect David's row in roster
			GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			GenericFunctions.waitWebDriver(1000);
			SchedulerShiftManagementPageObj.DavidPeltonProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8 : Click on Zac's profile image
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacWoodallProfileImage);
			SchedulerShiftManagementPageObj.ZacWoodallProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
//			// Step 9 : Deselect saturday
//			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacwoodalSaturday);
//			SchedulerShiftManagementPageObj.ZacwoodalSaturday.click();
//			GenericFunctions.waitWebDriver(2000);
//			
//			// Step 10 : Deselect Sunday
//			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacwoodalSunday);
//			SchedulerShiftManagementPageObj.ZacwoodalSunday.click();
//			GenericFunctions.waitWebDriver(2000);
						
			// Step 11 : Click on Header Shift
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 12 : Go to Shift details Section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(3000);
			String title2 = SchedulerShiftManagementPageObj.FirstShiftDetails.getAttribute("title");
			System.out.println(title2);
			
			// Step 10 : Verify if shifts are created correctly
			if(title1.contains("Cleaner")||title2.contains("Cleaner"))
			{
			ExtentTestManager.getTest().log(LogStatus.PASS, "Shifts details verified successfully in Shift deatils section");
			Assert.assertTrue(true, "Shifts details verified successfully in Shift deatils section");
			System.out.println("Shifts details verified successfully in Shift deatils section");
			}	
			
			try
			{
				// Extent Manager for generating report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to cancel the shift assignments and then delete the unassigned shifts");	

				// Step 7: Select first shift in shift details section
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftDetails);
				SchedulerShiftManagementPageObj.FirstShiftDetails.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 8: Click on Cancel assignment Button
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.CancelAssignmentsButton);
				SchedulerShiftManagementPageObj.CancelAssignmentsButton.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToDisAppear(NewResourceSetupPageObj.BlockingMessagePopup);
				GenericFunctions.waitWebDriver(2000);

				// Step 9: Go to Unassigned shifts section
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
				SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
				GenericFunctions.waitWebDriver(5000);
				
				// Verify if the cancelled shifts is now present in the unassigned section
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts);
				boolean CancelledShiftStatus = SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts.isDisplayed();
				System.out.println("Is cancelled shift present in unassigned shift section : "+CancelledShiftStatus);
				if(CancelledShiftStatus==true)
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "The assignments have been successfully cancelled");
					Assert.assertTrue(true, "The assignments have been successfully cancelled");
				}
				
				
				// Extent Manager for generating report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to delete the unassigned shifts");
				
				// Step 10: Click Select all Check Box
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox);
				SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 11: Click on cancel Assignments Button
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DeleteButton);
				SchedulerShiftManagementPageObj.DeleteButton.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 12: Confirm Yes on PopUp
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PopUpYesButton);
				SchedulerShiftManagementPageObj.PopUpYesButton.click();
				GenericFunctions.waitWebDriver(4000);
				
				// Verify if shifts are deleted successfully
				
					try
					{
						boolean StatusOfanyUnassignedShifts = SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts.isDisplayed();
						if(StatusOfanyUnassignedShifts==false)
						{
							ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is able to delete the unassigned shifts successfully");
							Assert.assertTrue(true, "Scheduler is able to delete the unassigned shifts successfully");
							System.out.println("Scheduler is able to delete the unassigned shifts successfully");
						}
					}
					catch(Exception e)
					{
						ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to delete the unassigned shifts");
						ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
						Assert.fail("Scheduler is unable to delete the unassigned shifts"+e.getLocalizedMessage());
					}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to cancel the assignments ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler failed to cancel the assignments "+e.getLocalizedMessage());
			}	
			
	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to verify the details of shift in Shiftdetails section ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to verify the details of shift in Shiftdetails section "+e.getLocalizedMessage());
		}
	}
	
	public void CancelAssignedAndDeleteUnassignedShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to cancel the shift assignments and then delete the unassigned shifts");

			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 4: Click on  Zac's profile image
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacWoodallProfileImage);
			SchedulerShiftManagementPageObj.ZacWoodallProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Click on header
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Go to Shift details Section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 7: Select first shift in shift details section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftDetails);
			SchedulerShiftManagementPageObj.FirstShiftDetails.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8: Click on Cancel assignment Button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.CancelAssignmentsButton);
			SchedulerShiftManagementPageObj.CancelAssignmentsButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToDisAppear(NewResourceSetupPageObj.BlockingMessagePopup);
			GenericFunctions.waitWebDriver(2000);

			// Step 9: Go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(5000);
			
			// Verify if the cancelled shifts is now present in the unassigned section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts);
			boolean CancelledShiftStatus = SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts.isDisplayed();
			System.out.println("Is cancelled shift present in unassigned shift section : "+CancelledShiftStatus);
			if(CancelledShiftStatus==true)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "The assignments have been successfully cancelled");
				Assert.assertTrue(true, "The assignments have been successfully cancelled");
			}
			
			
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to delete the unassigned shifts");
			
			// Step 10: Click Select all Check Box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox);
			SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 11: Click on cancel Assignments Button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DeleteButton);
			SchedulerShiftManagementPageObj.DeleteButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 12: Confirm Yes on PopUp
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PopUpYesButton);
			SchedulerShiftManagementPageObj.PopUpYesButton.click();
			GenericFunctions.waitWebDriver(4000);
			
			// Verify if shifts are deleted successfully
				try
				{
					boolean StatusOfanyUnassignedShifts = SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts.isDisplayed();
					if(StatusOfanyUnassignedShifts==false)
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is able to delete the unassigned shifts successfully");
						Assert.assertTrue(true, "Scheduler is able to delete the unassigned shifts successfully");
						System.out.println("Scheduler is able to delete the unassigned shifts successfully");
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to delete the unassigned shifts");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler is unable to delete the unassigned shifts"+e.getLocalizedMessage());
				}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to cancel the assignments ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to cancel the assignments "+e.getLocalizedMessage());
		}	
	}
	
	public void AdhocTasks() throws InterruptedException
	{
		
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String ShiftType = objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("Selected Shift Type is :"+ShiftType);
		
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to add Extra Tasks to the shift");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on All Shifts Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.ShiftTypesTab);
			NewResourceSetupPageObj.ShiftTypesTab.click();
			GenericFunctions.waitWebDriver(2000);
				
				try
				{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to fetch data from excel sheet");

				
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
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to get data from excel aheet");
				System.out.println("Failed to get data from excel aheet");

			}

			
			// Step 5: Click on new in Add tasks section
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AddTask);
			NewResourceSetupPageObj.AddTask.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Add Task Name
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.NewTaskName);
			NewResourceSetupPageObj.NewTaskName.click();
			NewResourceSetupPageObj.NewTaskName.sendKeys("Test Automation name");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Add Task Description
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.NewTaskDescription);
			NewResourceSetupPageObj.NewTaskDescription.click();
			NewResourceSetupPageObj.NewTaskDescription.sendKeys("Test Automation description");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 7: Add Task Description
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();

			
			// verify if the new task is added
			
			try
			{
				// Extent Manager for generating report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to add Extra Tasks to the shift");
			
				// Step 8: Select Cleaner
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.CleanerDepartment);
				NewResourceSetupPageObj.CleanerDepartment.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Check if added task is present
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.NewTask);
				NewResourceSetupPageObj.NewTask.click();
				
				// Delete the recently added task
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DeleteTaskButton);
				NewResourceSetupPageObj.DeleteTaskButton.click();
				
				// Confirm Yes to pop Up
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.PopUpYesButton);
				NewResourceSetupPageObj.PopUpYesButton.click();
				
				ExtentTestManager.getTest().log(LogStatus.PASS, "Tasks added successfully ");
				Assert.assertTrue(true, "Tasks added successfully ");
				System.out.println("Tasks added successfully ");
			
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is Unable to add Extra Tasks ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler is Unable to add Extra Tasks "+e.getLocalizedMessage());
			}
					
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is Unable to add Extra Tasks ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is Unable to add Extra Tasks "+e.getLocalizedMessage());
		}
	}
	
	public void VerifyAdhocTasks() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to verify if extra tasks(Adhoc tasks) are added correctly");
			
			// Step 1: Check the first required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Check the Second required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.LastEmployeeMondayBox);
			SchedulerShiftManagementPageObj.LastEmployeeMondayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 4: Click on  Tasks Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.TasksTab);
			SchedulerShiftManagementPageObj.TasksTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			try
			{
			// Verify if shifts are added correctly;
				
			// Step 5: Get text from Task name holder		
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.TaskNameHolderInTasksSection);
			SchedulerShiftManagementPageObj.TaskNameHolderInTasksSection.click();
			String TaskName = SchedulerShiftManagementPageObj.TaskNameHolderInTasksSection.getAttribute("title");
			System.out.println(TaskName);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Get text from Task description holder
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.TaskDescriptionHolderInTasksSection);
			String TaskDescription = SchedulerShiftManagementPageObj.TaskDescriptionHolderInTasksSection.getAttribute("title");
			System.out.println(TaskDescription);
			GenericFunctions.waitWebDriver(2000);
			
			if(TaskName.equals("Verifying adding Tasks")||TaskDescription.equals("Verifying adding Tasks"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Tasks are correctly added");
				Assert.assertTrue(true, "Tasks are correctly added");
				System.out.println("Tasks are correctly added");				
			}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts NOT added correctly ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Shifts NOT added correctly "+e.getLocalizedMessage());
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts NOT added correctly ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Shifts NOT added correctly "+e.getLocalizedMessage());
		}
	}
	
	public void PublishTheShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to publish the assigned shifts");
			
			
			// Step 1: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 2: Click on Daved's profile image
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			SchedulerShiftManagementPageObj.DavidPeltonProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3 : Uncheck saturday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonSaturday);
			SchedulerShiftManagementPageObj.DavidPeltonSaturday.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4 : Uncheck sunday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonSunday);
			SchedulerShiftManagementPageObj.DavidPeltonSunday.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Zac's profile image
			GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.ZacWoodallProfileImage);
			SchedulerShiftManagementPageObj.ZacWoodallProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4 : Uncheck ssturday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacwoodalSaturday);
			SchedulerShiftManagementPageObj.ZacwoodalSaturday.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4 : Uncheck ssturday
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ZacwoodalSunday);
			SchedulerShiftManagementPageObj.ZacwoodalSunday.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Click on Header shift 
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 5: Go to Shift details section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 6: Select all assigned shifts
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllAssignedShiftsCheckBox);
			SchedulerShiftManagementPageObj.SelectAllAssignedShiftsCheckBox.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 7: Click on Publish Button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PublishButton);
			SchedulerShiftManagementPageObj.PublishButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8: Confirm Yes to Pop Up
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PopUpYesButton);
			SchedulerShiftManagementPageObj.PopUpYesButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			GenericFunctions.waitWebDriver(2000);

			// Step 9: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 10: Click on Daved's profile image
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			SchedulerShiftManagementPageObj.DavidPeltonProfileImage.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 11: Click on Zac's profile image
			GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.ZacWoodallProfileImage);
			SchedulerShiftManagementPageObj.ZacWoodallProfileImage.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 12: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 13: Go to Shift details section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(3000);
			
			try
			{
			// Verify if the shifts are successfully published
				
			// Step 9: Check the Publish status for first employee
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.LastShiftStatus);
			SchedulerShiftManagementPageObj.LastShiftStatus.click();
			String PublishStatusOfLastShift = SchedulerShiftManagementPageObj.LastShiftStatus.getAttribute("title");
			System.out.println("The status of the shifts is :"+PublishStatusOfLastShift);
			GenericFunctions.waitWebDriver(2000);
			
				if(PublishStatusOfLastShift.equals("Published"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "The assigned shifts are published successfully ");
					Assert.assertTrue(true, "The assigned shifts are published successfully ");
					System.out.println("The assigned shifts are published successfully ");
				}
			
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts Could NOT be published successfully ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Shifts Could NOT be published successfully "+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts Could NOT be published successfully ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Shifts Could NOT be published successfully "+e.getLocalizedMessage());
		}
	}
	
	public void DeleteUnassignedShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to delete the unassigned shifts");
			
			// Step 1: Click on Header Shift
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 1: Click Select all Check Box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllAssignedShiftsCheckBox);
			SchedulerShiftManagementPageObj.SelectAllUnassignedShiftsCheckBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on cancel Assignments Button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.DeleteButton);
			SchedulerShiftManagementPageObj.DeleteButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Confirm Yes on PopUp
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PopUpYesButton);
			SchedulerShiftManagementPageObj.PopUpYesButton.click();
			GenericFunctions.waitWebDriver(4000);
			
			// Verify if shifts are deleted successfully
			
				try
				{
					boolean StatusOfanyUnassignedShifts = SchedulerShiftManagementPageObj.FirstRowOfUnassignedShifts.isDisplayed();
					if(StatusOfanyUnassignedShifts==false)
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is able to delete the unassigned shifts successfully");
						Assert.assertTrue(true, "Scheduler is able to delete the unassigned shifts successfully");
						System.out.println("Scheduler is able to delete the unassigned shifts successfully");
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to delete the unassigned shifts");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Scheduler is unable to delete the unassigned shifts"+e.getLocalizedMessage());
				}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to delete the unassigned shifts");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to delete the unassigned shifts"+e.getLocalizedMessage());
		}
	}
	
	
	public void SetStartDayOfTheWeek() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso=null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetday");
		String Day =objListOFTestDataForContoso.get(0).getDay();
		System.out.println("The selected Day is : "+Day);
		try
		{		
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to set the start day of week");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Workforce Management Parameters Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.WorkforceManagementParametersTab);
			SchedulerShiftManagementPageObj.WorkforceManagementParametersTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Click on Week start day Place holder
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.WeekStartDayHolder);
			SchedulerShiftManagementPageObj.WeekStartDayHolder.click();
			GenericFunctions.waitWebDriver(2000);
	
			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to fetch Day value from the excel sheet");

				
				if(Day.equals("MONDAY"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.MondayOption);
				SchedulerShiftManagementPageObj.MondayOption.click();
				GenericFunctions.waitWebDriver(2000);
				}
				
				else if(Day.equals("TUESDAY"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.TuesdayOption);
				SchedulerShiftManagementPageObj.TuesdayOption.click();
				GenericFunctions.waitWebDriver(2000);
				}
				
				else if(Day.equals("WEDNESDAY"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.WednesdayOption);
				SchedulerShiftManagementPageObj.WednesdayOption.click();
				GenericFunctions.waitWebDriver(2000);
				}
				
				else if(Day.equals("THURSDAY"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ThursdayOption);
				SchedulerShiftManagementPageObj.ThursdayOption.click();
				GenericFunctions.waitWebDriver(2000);
				}
				
				else if(Day.equals("FRIDAY"))
				{
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FridayOption);
				SchedulerShiftManagementPageObj.FridayOption.click();
				GenericFunctions.waitWebDriver(2000);
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to fetch data from the excel sheet");
				System.out.println("Failed to fetch data from the excel sheet");

			}
			
			// Step 6: Click on Save
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
			NewResourceSetupPageObj.SaveButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to set the start day of week");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler is unable to set the start day of week"+e.getLocalizedMessage());
		}
		
	}
	
	public void VerifyStartDayOfWeek() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso=null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetday");
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Day =objListOFTestDataForContoso.get(0).getDay();
		String Location =objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selected location is :"+Location);
		System.out.println("The selected profile is : "+Day);
		
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to check if the start day of the week is changed.");
			
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on All Schedules Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AllSchedulesTab);
			NewResourceSetupPageObj.AllSchedulesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Send keys to input Site Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SiteParameterHolder);
			NewResourceSetupPageObj.SiteParameterHolder.click();
			NewResourceSetupPageObj.SiteParameterHolder.sendKeys("MainOffice",Keys.ENTER);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Select Welding as input Location Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationParameterDropdown);
			NewResourceSetupPageObj.LocationParameterDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RandwickPowerstationDropdown);
			NewResourceSetupPageObj.RandwickPowerstationDropdown.click();
			GenericFunctions.waitWebDriver(1000);
				
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
			
			// Step 5: Send Past Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DateParameterHolder);
			NewResourceSetupPageObj.DateParameterHolder.click();
			NewResourceSetupPageObj.DateParameterHolder.sendKeys(CurrentDate);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on OK
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(10000);
			
			// Step 7: Click on Header shift
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8: Get text from the first position of roster
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstDayInRoster);
			String day = SchedulerShiftManagementPageObj.FirstDayInRoster.getText();
			System.out.println(Day);
			GenericFunctions.waitWebDriver(2000);
			
			
			if(day.contains(Day))
			{	
				
				ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler able to change the start day of the week successfully");
				Assert.assertTrue(true, "Scheduler able to change the start day of the week successfully");
				System.out.println("Scheduler able to change the start day of the week successfully");
			}
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to change the start day of the week");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to change the start day of the week"+e.getLocalizedMessage());
		}	
		
	}
	public void AssignShifts() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to assign the shifts manually ");
			
			// Step 1: Minimize Shifts Section
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Check the first required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Click on Unassigned Shifts Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 5: Check the first Shift check box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftCheckbox);
			SchedulerShiftManagementPageObj.FirstShiftCheckbox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on Assign
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.AssignButton);
			SchedulerShiftManagementPageObj.AssignButton.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 7: Click on Header Shift 
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(5000);
			
			// Step 9: Check the second required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 11: Click on Unassigned Shifts Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.UnassignedShiftsTab);
			SchedulerShiftManagementPageObj.UnassignedShiftsTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 12: Check the first Shift check box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstShiftCheckbox);
			SchedulerShiftManagementPageObj.FirstShiftCheckbox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 13: Click on Assign
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.AssignButton);
			SchedulerShiftManagementPageObj.AssignButton.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);

			// Step 14: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(5000);
					
			// Step 15: Verify if the shift has been assigned to the corresponding selected box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			String AreaValueText1 = SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.getAttribute("aria-valuetext");
			System.out.println(AreaValueText1);
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox);
			String AreaValueText2 = SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.getAttribute("aria-valuetext");
			System.out.println(AreaValueText2);
			if(AreaValueText1.equals("Created")||AreaValueText2.equals("Created"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Successfully assigned the shifts manually");
				Assert.assertTrue(true, "Successfully assigned the shifts manually");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to assign the shifts manually");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to assign the shifts manually"+e.getLocalizedMessage());
		}
	}

	public void PublishShiftsForWorker() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to publish the assigned shifts");
			
			// Step 1: Check the first required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Check the Second required box
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			// Step 4: Click on  Shift details Tab
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.ShiftDetailsTab);
			SchedulerShiftManagementPageObj.ShiftDetailsTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 5: Select all shifts
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.SelectAllAssignedShiftsCheckBox);
			SchedulerShiftManagementPageObj.SelectAllAssignedShiftsCheckBox.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on Publish Button
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PublishButton);
			SchedulerShiftManagementPageObj.PublishButton.click();
			GenericFunctions.waitWebDriver(2000);

			
			// Step 7: Confirm Yes to Pop Up
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.PopUpYesButton);
			SchedulerShiftManagementPageObj.PopUpYesButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);

			// Step 8: Click on Header shift to go to Unassigned shifts section
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(3000);
			
			try
			{
			// Verify if the shifts are successfully published
				
			// Step 9: Check the Publish status for first employee
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeMondayBox);
			SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.click();
			String PublishStatusOfFirstShift = SchedulerShiftManagementPageObj.FourthEmployeeMondayBox.getAttribute("aria-valuetext");
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Check the Publish status for Second employee
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox );
			SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.click();
			String PublishStatusOfSecondShift = SchedulerShiftManagementPageObj.FourthEmployeeTuesdayBox.getAttribute("aria-valuetext");
			GenericFunctions.waitWebDriver(2000);
			
			if(PublishStatusOfFirstShift.equals("Published")||PublishStatusOfSecondShift.equals("Published"))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "The assigned shifts are published successfully ");
				Assert.assertTrue(true, "The assigned shifts are published successfully ");
				System.out.println("The assigned shifts are published successfully ");
			}
			
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts Could NOT be published successfully ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Shifts Could NOT be published successfully "+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Shifts Could NOT be published successfully ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Shifts Could NOT be published successfully "+e.getLocalizedMessage());
		}
	}
	
	public void SelectRosterDaysForDavid() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to select all Roster boxes for David Pelton");
		
			// Step 1: Minimize Shifts Section
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on David'd Profile Image
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.DavidPeltonProfileImage);
			SchedulerShiftManagementPageObj.DavidPeltonProfileImage.click();
			GenericFunctions.waitWebDriver(3000);
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler is successfully able to select all Roster boxes for David Pelton");
				Assert.assertTrue(true, "Scheduler is successfully able to select all Roster boxes for David Pelton ");
				System.out.println("Scheduler is successfully able to select all Roster boxes for David Pelton ");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to select David Pelton");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler unable to select David Pelton "+e.getLocalizedMessage());
		}
	}	
		public void SelectRosterDaysForZac() throws InterruptedException
		{
			try
			{
				// Extent Manager for generating report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to select all Roster boxes for Zac Woodall");
				
				// Step 1: Click on Zac's profile imageSchedulerShiftManagementPageObj.DavidPeltonProfileImage
				GenericFunctions.scrollToElement(SchedulerShiftManagementPageObj.ZacWoodallProfileImage);
				SchedulerShiftManagementPageObj.ZacWoodallProfileImage.click();
				GenericFunctions.waitWebDriver(2000);
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is successfully able to select all Roster boxes for David Pelton and Zac Woodall");
					Assert.assertTrue(true, "Scheduler is successfully able to select all Roster boxes for David Pelton and Zac Woodall");
					System.out.println("Scheduler is successfully able to select all Roster boxes for David Pelton and Zac Woodall");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler unable to select Zac Wodall ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler unable to select Zac Wodall "+e.getLocalizedMessage());
			}		
	}
	
	public void SetMondayAsTheStartDayOfWeek() throws InterruptedException
	{
		
			try
			{		
				// Extent Manager for generating report
				ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to set the start day of week");
				
				// Step 1: Click on Hamburger 
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
				NewResourceSetupPageObj.Hamburger.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 2: Click on Workforce Management
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
				NewResourceSetupPageObj.WorkforceManagementTab.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 3: Click on Workforce Management Parameters Tab
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.WorkforceManagementParametersTab);
				SchedulerShiftManagementPageObj.WorkforceManagementParametersTab.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 4: Click on Week start day Place holder
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.WeekStartDayHolder);
				SchedulerShiftManagementPageObj.WeekStartDayHolder.click();
				GenericFunctions.waitWebDriver(2000);

				// Step 5: Select Monday
				GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.MondayOption);
				SchedulerShiftManagementPageObj.MondayOption.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 6: Click on Save
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SaveButton);
				NewResourceSetupPageObj.SaveButton.click();
				GenericFunctions.waitWebDriver(3000);
				
				
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler is unable to set the start day of week");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Scheduler is unable to set the start day of week"+e.getLocalizedMessage());
			}
	}
	
	public void VerifyIfMondayIsSetBackAsTheStartDay() throws InterruptedException
	{
		try
		{
			// Extent Manager for generating report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Scheduler is trying to check if the start day of the week is changed.");
			
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on All Schedules Tab
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.AllSchedulesTab);
			NewResourceSetupPageObj.AllSchedulesTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Send keys to input Site Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.SiteParameterHolder);
			NewResourceSetupPageObj.SiteParameterHolder.click();
			NewResourceSetupPageObj.SiteParameterHolder.sendKeys("MainOffice",Keys.ENTER);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 4: Select Welding as input Location Parameter
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationParameterDropdown);
			NewResourceSetupPageObj.LocationParameterDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.RandwickPowerstationDropdown);
			NewResourceSetupPageObj.RandwickPowerstationDropdown.click();
			GenericFunctions.waitWebDriver(1000);
				
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WeldingTab);
			NewResourceSetupPageObj.WeldingTab.click();
			GenericFunctions.waitWebDriver(1000);			
			
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.LocationDropdownOkButton);
			NewResourceSetupPageObj.LocationDropdownOkButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 5: Send Past Date
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.DateParameterHolder);
			NewResourceSetupPageObj.DateParameterHolder.click();
			NewResourceSetupPageObj.DateParameterHolder.sendKeys(CurrentDate);
			GenericFunctions.waitWebDriver(2000);
			
			// Step 6: Click on OK
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(10000);
			
			// Step 7: Click on Header shift
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.HeaderShift);
			SchedulerShiftManagementPageObj.HeaderShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 8: Get text from the first position of roster
			GenericFunctions.waitForElementToAppear(SchedulerShiftManagementPageObj.FirstDayInRoster);
			String Day = SchedulerShiftManagementPageObj.FirstDayInRoster.getText();
			System.out.println(Day);
			GenericFunctions.waitWebDriver(2000);
			
			
			if(Day.contains("MONDAY"))
			{	
				
				ExtentTestManager.getTest().log(LogStatus.PASS, "Scheduler able to change the start day of the week successfully");
				Assert.assertTrue(true, "Scheduler able to change the start day of the week successfully");
				System.out.println("Scheduler able to change the start day of the week successfully");
			}
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Scheduler failed to change the start day of the week");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Scheduler failed to change the start day of the week"+e.getLocalizedMessage());
		}
	}
	
}
