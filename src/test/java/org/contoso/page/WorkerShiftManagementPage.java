package org.contoso.page;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.contoso.generic.ExtentTestManager;
import org.contoso.generic.GenericFunctions;
import org.contoso.generic.ReadTestDataFromExcel;
import org.contoso.pageobject.NewResourceSetupPageObject;
import org.contoso.pageobject.SchedulerShiftManagementPageObject;
import org.contoso.pageobject.WorkerShiftManagementPageObject;
import org.contoso.startup.BaseTest;
import org.contoso.testdata.TestDataForContoso;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class WorkerShiftManagementPage extends BaseTest {

	SchedulerShiftManagementPageObject SchedulerShiftManagementPageObj = PageFactory.initElements(driver, SchedulerShiftManagementPageObject.class); 
	NewResourceSetupPageObject NewResourceSetupPageObj = PageFactory.initElements(driver, NewResourceSetupPageObject.class);
	WorkerShiftManagementPageObject WorkerShiftManagementPageObj = PageFactory.initElements(driver, WorkerShiftManagementPageObject.class);
	
	public void AcceptShift() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selected location is :"+Location);
		
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Worker is trying to accept the Shifts assigned to him ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Workforce Management Image
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkforceManagementDashboard);
			WorkerShiftManagementPageObj.WorkforceManagementDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 4: Click on Configure My Workspace Tab
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab);
			WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 5: Input Date
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder.click();
			GenericFunctions.waitWebDriver(1000);
			
			Robot Rob = new Robot();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			Rob.keyPress(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			

			// Step 6: Input Site
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder.click();
			GenericFunctions.waitWebDriver(1000);
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice);
			WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice.click();
			
			// Step 7: Input Location as welding
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder.click();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(1000);
			
			// Step 10: Select Location
			try
			{						
				if(Location.equals("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WeldingOption);
						WorkerShiftManagementPageObj.WeldingOption.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				 {				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.OperatiosOption);
						WorkerShiftManagementPageObj.OperatiosOption.click();
						GenericFunctions.waitWebDriver(4000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				 }
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				 {
					ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
					GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
					WorkerShiftManagementPageObj.ElectricalInstrOption.click();
					GenericFunctions.waitWebDriver(4000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}
			
			// Step 8: Click on Ok button
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 9: Select Your Shift
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MyFirstShift);
			WorkerShiftManagementPageObj.MyLastShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Click on confirm Button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfirmButtonInDashboard);
			WorkerShiftManagementPageObj.ConfirmButtonInDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			
			 // Step 11: Verify if Shift is correctly Confirmed
				try
				{
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfirmedShiftsTile);
				WorkerShiftManagementPageObj.ConfirmedShiftsTile.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 12: Get text from Status field 
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ShiftStatus);
				String ShiftStatus = WorkerShiftManagementPageObj.ShiftStatus.getAttribute("aria-valuetext");
				System.out.println(ShiftStatus);
				if(ShiftStatus.equals("Confirmed"))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "Shift Correctly accepted by the worker ");
					Assert.assertTrue(true, "Shift Correctly accepted by the worker ");
					System.out.println("Shift Correctly accepted by the worker ");
				}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Worker could NOT accept the Shifts assigned to him ");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
					Assert.fail("Worker could NOT accept the Shifts assigned to him "+e.getLocalizedMessage());
				}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Worker could NOT accept the Shifts assigned to him ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Worker could NOT accept the Shifts assigned to him "+e.getLocalizedMessage());
		}
	}
	
	public void RejectShift() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		System.out.println("The selected location is :"+Location);
		
		try
		{
			// Extent Manager for generating Report
			ExtentTestManager.getTest().log(LogStatus.INFO, "Worker is trying to Reject the Shifts assigned to him ");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Workforce Management Image
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkforceManagementDashboard);
			WorkerShiftManagementPageObj.WorkforceManagementDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 4: Click on Configure My Workspace Tab
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab);
			WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 5: Input Date
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder.click();
			GenericFunctions.waitWebDriver(1000);
			
			Robot Rob = new Robot();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			Rob.keyPress(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			

			// Step 6: Input Site
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder.click();
			GenericFunctions.waitWebDriver(1000);
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice);
			WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice.click();
			
			// Step 7: Input Location as welding
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder.click();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(1000);
			
			// Step 10: Select Location
			try
			{						
				if(Location.equalsIgnoreCase("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WeldingOption);
						WorkerShiftManagementPageObj.WeldingOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				 {				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.OperatiosOption);
						WorkerShiftManagementPageObj.OperatiosOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				 }
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				 {
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
						String IsAreaSelected = WorkerShiftManagementPageObj.ElectricalInstrOption.getAttribute("aria-selected");
						if(IsAreaSelected.equals("false"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(1000);
					}
				else if(IsAreaSelected.equals("true"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

					}

				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}
			
			// Step 8: Click on Ok button
//			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.OkButton);
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 9: Select Your Shift
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MyFirstShift);
			WorkerShiftManagementPageObj.MyUnconfirmedShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Click on confirm Button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.RejectButtonInDashboard);
			WorkerShiftManagementPageObj.RejectButtonInDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			
			try
			{
			// Verify if shift has been rejected correctly or not
			boolean UnconfirmedShiftStatus = WorkerShiftManagementPageObj.MyFirstShift.isDisplayed();
			if(UnconfirmedShiftStatus==false)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Worker could Reject the Shifts assigned to him ");
				Assert.assertTrue(true,"Worker could Reject the Shifts assigned to him ");
				System.out.println("Worker could  Reject the Shifts assigned to him ");
			}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Worker could NOT Reject the Shifts assigned to him ");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				Assert.fail("Worker could NOT Reject the Shifts assigned to him "+e.getLocalizedMessage());
			}
			
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Worker could NOT Reject the Shifts assigned to him ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Worker could NOT Reject the Shifts assigned to him "+e.getLocalizedMessage());
		}
	}
	
	public void RequestForShiftSwap() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		String ShiftType =  objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("The selected location is :"+Location);
		
		try
		{
			// Extent Manager for generating reports
			ExtentTestManager.getTest().log(LogStatus.INFO, "David is trying to request for the swap of shift");
			
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Workforce Management Image
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkforceManagementDashboard);
			WorkerShiftManagementPageObj.WorkforceManagementDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 4: Click on Configure My Workspace Tab
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab);
			WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 5: Input Date
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder.click();
			GenericFunctions.waitWebDriver(1000);
			
			Robot Rob = new Robot();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			Rob.keyPress(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			

			// Step 6: Input Site
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder.click();
			GenericFunctions.waitWebDriver(1000);
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice);
			WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice.click();
			
			// Step 7: Input Location as welding
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder.click();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(1000);
			
			// Step 8: Select Location
			try
			{						
				if(Location.equalsIgnoreCase("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WeldingOption);
						WorkerShiftManagementPageObj.WeldingOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				 {				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.OperatiosOption);
						WorkerShiftManagementPageObj.OperatiosOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				 }
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				 {
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
						String IsAreaSelected = WorkerShiftManagementPageObj.ElectricalInstrOption.getAttribute("aria-selected");
						if(IsAreaSelected.equals("false"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(1000);
					}
				else if(IsAreaSelected.equals("true"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

					}
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");

			}
			
			// Step 8: Click on Ok button
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 9: Select Your Shift
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MyFirstShift);
			WorkerShiftManagementPageObj.MyFirstShift.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 10: Click on confirm Button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.SwapRequestButton);
			WorkerShiftManagementPageObj.SwapRequestButton.click();
			GenericFunctions.waitWebDriver(2000);
						
			// Step 12: Input swap shift date
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MyShiftDateHolder);
			String MyShiftDate = WorkerShiftManagementPageObj.MyShiftDateHolder.getAttribute("title");
			System.out.println("My Shift date is :"+MyShiftDate);
			WorkerShiftManagementPageObj.SwapShiftDateHolder.sendKeys(MyShiftDate);
			GenericFunctions.waitWebDriver(2000);

			// Step 13: Input request receiver's name
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MyShiftDateHolder);
			WorkerShiftManagementPageObj.SwapWithHolder.sendKeys("Zac Woodall");
			GenericFunctions.waitWebDriver(2000);

			// Step 14: Select Shift Type
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.SwapShiftType);
			WorkerShiftManagementPageObj.SwapShiftType.sendKeys(ShiftType);
			GenericFunctions.waitWebDriver(2000);

			// Step 15: Click on Ok button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ShiftSwapOkButton);
			WorkerShiftManagementPageObj.ShiftSwapOkButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 16: Click on My Swap Shifts Button
			GenericFunctions.scrollToElement(WorkerShiftManagementPageObj.MySwapRequestsLink);
			GenericFunctions.waitWebDriver(5000);
			WorkerShiftManagementPageObj.MySwapRequestsLink.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 17: Select the draft 
			GenericFunctions.scrollToElement(WorkerShiftManagementPageObj.ShiftSwapDrafts);
			WorkerShiftManagementPageObj.ShiftSwapDrafts.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 18: Click on Workflow
			GenericFunctions.waitForElementToAppearOnScreen(WorkerShiftManagementPageObj.WorkflowButton);
			WorkerShiftManagementPageObj.WorkflowButton.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 19: Click on Submit Button
			GenericFunctions.waitForElementToAppearOnScreen(WorkerShiftManagementPageObj.WorkflowSubmitButton);
			WorkerShiftManagementPageObj.WorkflowSubmitButton.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 20: Add text
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowCommentSection);
			WorkerShiftManagementPageObj.WorkflowCommentSection.sendKeys("No Worries David, I accept for the shift swap");
			GenericFunctions.waitWebDriver(2000);

			// Step 21: Click on Submit Button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowTextSubmitButton);
			WorkerShiftManagementPageObj.WorkflowTextSubmitButton.click();
			GenericFunctions.waitWebDriver(5000);
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "David is unable to request for the swap of shift");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("David is unable to request for the swap of shift"+e.getLocalizedMessage());
		}
	}
	
	public void AcceptSwapRequestAsaCoworker() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		String ShiftType =  objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("The selected location is :"+Location);
		
		try
		{
			// Extent Manager for generating reports
			ExtentTestManager.getTest().log(LogStatus.INFO, "Zac is trying to accept the reeceived swap request from David");
			
			// Step 1: Click on Hamburger 
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
			NewResourceSetupPageObj.Hamburger.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 2: Click on Workforce Management
			GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
			NewResourceSetupPageObj.WorkforceManagementTab.click();
			GenericFunctions.waitWebDriver(2000);
			
			// Step 3: Click on Workforce Management Image
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkforceManagementDashboard);
			WorkerShiftManagementPageObj.WorkforceManagementDashboard.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
			
			// Step 4: Click on Configure My Workspace Tab
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab);
			WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab.click();
			GenericFunctions.waitWebDriver(2000);

			// Step 5: Input Date
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder.click();
			GenericFunctions.waitWebDriver(1000);
			
			Robot Rob = new Robot();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			Rob.keyPress(KeyEvent.VK_ENTER);
			GenericFunctions.waitWebDriver(2000);
			

			// Step 6: Input Site
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder.click();
			GenericFunctions.waitWebDriver(1000);
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice);
			WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice.click();
			
			// Step 7: Input Location as welding
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder);
			WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder.click();
			Rob.keyPress(KeyEvent.VK_ALT);
			Rob.keyPress(KeyEvent.VK_DOWN);
			GenericFunctions.waitWebDriver(1000);
			
			// Step 10: Select Location
			try
			{						
				if(Location.equalsIgnoreCase("WELDING"))
				 {		
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WeldingOption);
						WorkerShiftManagementPageObj.WeldingOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

				 }	
				if(Location.equalsIgnoreCase("OPERATIONS"))
				 {				
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.OperatiosOption);
						WorkerShiftManagementPageObj.OperatiosOption.click();
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

				 }
				else if(Location.equalsIgnoreCase("ELECTRINSTR"))
				 {
						ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
						String IsAreaSelected = WorkerShiftManagementPageObj.ElectricalInstrOption.getAttribute("aria-selected");
						if(IsAreaSelected.equals("false"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(1000);
					}
				else if(IsAreaSelected.equals("true"))
					{
						GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						WorkerShiftManagementPageObj.ElectricalInstrOption.click();
						GenericFunctions.waitWebDriver(500);
						ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

					}
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
				System.out.println("failed to fetch the location data from excel sheet");
			}
			
			// Step 8: Click on Ok button
			NewResourceSetupPageObj.OkButton.click();
			GenericFunctions.waitWebDriver(2000); 
			
			// Step 9: Click on MySwapRequestsLink
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.MySwapRequestsLink);
			WorkerShiftManagementPageObj.MySwapRequestsLink.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 10: Select the draft swap request
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ShiftSwapDrafts);
			WorkerShiftManagementPageObj.ShiftSwapDrafts.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 11: click on workflow
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowButton);
			WorkerShiftManagementPageObj.WorkflowButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 12: click on workflow submit
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowSubmitButton);
			WorkerShiftManagementPageObj.WorkflowSubmitButton.click();
			GenericFunctions.waitWebDriver(1000);
			
			// Step 13: Add text
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowCommentSection);
			WorkerShiftManagementPageObj.WorkflowCommentSection.sendKeys("No Worries David, I accept for the shift swap");
			GenericFunctions.waitWebDriver(1000);

			// Step 14: Click on Submit Button
			GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowTextSubmitButton);
			WorkerShiftManagementPageObj.WorkflowTextSubmitButton.click();
			GenericFunctions.waitWebDriver(1000);
				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Zac failed accept the reeceived swap request from David");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Zac failed to accept the reeceived swap request from David"+e.getLocalizedMessage());	
		}
	}
	

	
	
	public void AcceptSwapRequestAsaManager() throws InterruptedException
	{
		List <TestDataForContoso> objListOFTestDataForContoso = null;
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetlocation");
		objListOFTestDataForContoso = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetshifttype");
		String Location = objListOFTestDataForContoso.get(0).getLocation();
		String ShiftType =  objListOFTestDataForContoso.get(0).getShiftType();
		System.out.println("The selected location is :"+Location);
		
		try
		{
			
				// Extent Manager for generating reports
				ExtentTestManager.getTest().log(LogStatus.INFO, "Zac is trying to accept the reeceived swap request from David");
				
				// Step 1: Click on Hamburger 
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.Hamburger);
				NewResourceSetupPageObj.Hamburger.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 2: Click on Workforce Management
				GenericFunctions.waitForElementToAppear(NewResourceSetupPageObj.WorkforceManagementTab);
				NewResourceSetupPageObj.WorkforceManagementTab.click();
				GenericFunctions.waitWebDriver(2000);
				
				// Step 3: Click on Workforce Management Image
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkforceManagementDashboard);
				WorkerShiftManagementPageObj.WorkforceManagementDashboard.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitTillTheElementInVisible(SchedulerShiftManagementPageObj.BlockingMessage);
				
				// Step 4: Click on Configure My Workspace Tab
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab);
				WorkerShiftManagementPageObj.ConfigureMyWorkspaceTab.click();
				GenericFunctions.waitWebDriver(2000);

				// Step 5: Input Date
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder);
				WorkerShiftManagementPageObj.ConfigureWorkspaceDateHolder.click();
				GenericFunctions.waitWebDriver(1000);
				
				Robot Rob = new Robot();
				Rob.keyPress(KeyEvent.VK_ALT);
				Rob.keyPress(KeyEvent.VK_DOWN);
				GenericFunctions.waitWebDriver(2000);
				Rob.keyPress(KeyEvent.VK_ENTER);
				GenericFunctions.waitWebDriver(2000);
				

				// Step 6: Input Site
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder);
				WorkerShiftManagementPageObj.ConfigureWorkspaceSiteHolder.click();
				GenericFunctions.waitWebDriver(1000);
				Rob.keyPress(KeyEvent.VK_ALT);
				Rob.keyPress(KeyEvent.VK_DOWN);
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice);
				WorkerShiftManagementPageObj.ConfigureWorkspaceMainOffice.click();
				
				// Step 7: Input Location as welding
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder);
				WorkerShiftManagementPageObj.ConfigureWorkspaceLocationHolder.click();
				Rob.keyPress(KeyEvent.VK_ALT);
				Rob.keyPress(KeyEvent.VK_DOWN);
				GenericFunctions.waitWebDriver(1000);
				
				// Step 10: Select Location
				try
				{						
					if(Location.equalsIgnoreCase("WELDING"))
					 {		
							ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'WELDING' is a taken input from excel sheet ");
							GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WeldingOption);
							WorkerShiftManagementPageObj.WeldingOption.click();
							GenericFunctions.waitWebDriver(2000);
							ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, welding option is successfully selected from the location dropdown ");

					 }	
					if(Location.equalsIgnoreCase("OPERATIONS"))
					 {				
							ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'OPERATIONS' is a taken input from excel sheet ");
							GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.OperatiosOption);
							WorkerShiftManagementPageObj.OperatiosOption.click();
							GenericFunctions.waitWebDriver(2000);
							ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, operations option is successfully selected from the location dropdown ");

					 }
					else if(Location.equalsIgnoreCase("ELECTRINSTR"))
					 {
							ExtentTestManager.getTest().log(LogStatus.INFO, "NOTE : Location input value 'ELECTRINSTR' is a taken input from excel sheet ");
							String IsAreaSelected = WorkerShiftManagementPageObj.ElectricalInstrOption.getAttribute("aria-selected");
							if(IsAreaSelected.equals("false"))
						{
							GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
							WorkerShiftManagementPageObj.ElectricalInstrOption.click();
							GenericFunctions.waitWebDriver(1000);
						}
					else if(IsAreaSelected.equals("true"))
						{
							GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ElectricalInstrOption);
							WorkerShiftManagementPageObj.ElectricalInstrOption.click();
							GenericFunctions.waitWebDriver(500);
							WorkerShiftManagementPageObj.ElectricalInstrOption.click();
							GenericFunctions.waitWebDriver(500);
							ExtentTestManager.getTest().log(LogStatus.PASS, "NOTE : As per the input, Electr&instr option is successfully selected from the location dropdown ");

						}
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "failed to fetch the location data from excel sheet");
					System.out.println("failed to fetch the location data from excel sheet");

				}
				
				// Step 8: Click on Ok button
				NewResourceSetupPageObj.OkButton.click();
				GenericFunctions.waitWebDriver(2000); 
				
				// Step 9: Click on MySwapRequestsLink
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.AllSwapRequestsLink);
				WorkerShiftManagementPageObj.AllSwapRequestsLink.click();
				GenericFunctions.waitWebDriver(1000);
				
				// Step 10: Select draft swap request
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.ShiftSwapDrafts);
				WorkerShiftManagementPageObj.ShiftSwapDrafts.click();
				GenericFunctions.waitWebDriver(1000);
			
				// Step 11: Click on workflow button
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowButton);
				WorkerShiftManagementPageObj.WorkflowButton.click();
				GenericFunctions.waitWebDriver(1000);
				
				// Step 11: Click on workflow Submit button
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowSubmitButton);
				WorkerShiftManagementPageObj.WorkflowSubmitButton.click();
				GenericFunctions.waitWebDriver(1000);
				
				// Step 12: Add text
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowCommentSection);
				WorkerShiftManagementPageObj.WorkflowCommentSection.sendKeys("No worries @David ,@Zac I am approving the swap");
				GenericFunctions.waitWebDriver(1000);
				
				// Step 13: Click on Submit button
				GenericFunctions.waitForElementToAppear(WorkerShiftManagementPageObj.WorkflowTextSubmitButton);
				WorkerShiftManagementPageObj.WorkflowTextSubmitButton.click();
				GenericFunctions.waitWebDriver(1000);		
				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Manager is unable to approve the swap request");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Manager is unable to approve the swap request"+e.getLocalizedMessage());	
		}
	}
		
}

