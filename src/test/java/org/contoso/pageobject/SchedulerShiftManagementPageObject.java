package org.contoso.pageobject;

import org.contoso.startup.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SchedulerShiftManagementPageObject extends BaseTest{
WebDriver driver;

/* ************************************* Create Shift Requirement Page Objects ***************************** */	
	
	@FindBy(xpath = "//input[@name='SearchString']")
	public WebElement SchedulePageNameHolder;
	
	// Schedule Page New Button
	@FindBy(xpath = "//button[@data-dyn-controlname='NewButton']")
	public WebElement SchedulePageNewButton;
	
	// Shift Type Place Holder
	@FindBy(xpath = "//input[@name='NewShiftShiftType']")
	public WebElement ShiftTypePlaceHolder;
	
	// No Of Shifts Place Holder Page  
	@FindBy(xpath = "//input[@name='UnassingedShiftNoOfShifts']")
	public WebElement NoOfShiftsPlaceHolder;
	
	// Profile Place Holder  
	@FindBy(xpath = "//input[@name='NewShiftProfileId']")
	public WebElement ProfilePlaceHolder;
	
	// Date Place Holder  
	@FindBy(xpath = "//input[@name='UnassingedShiftDate']")
	public WebElement DatePlaceHolder;
	
	// Instruction Holder   
	@FindBy(xpath = "//input[@name='NewShiftInstructions']")
	public WebElement InstructionHolder;
	
	// Tasks New Button    
	@FindBy(xpath = "//button[@name='TasksNewButton']")
	public WebElement TasksNewButton;
	
	// Task Name Place Holder    
	@FindBy(xpath = "//div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[5]/input[1]")
	public WebElement TaskNamePlaceHolder;
	
	// Task Description Place Holder    
	@FindBy(xpath = "//div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[6]/input[1]")
	public WebElement TaskDescriptionPlaceHolder;
 
	// Perform an action Place Holder    
	@FindBy(xpath = "//input[@name='AppBarSearchField']")
	public WebElement PerformActionsSearchField;
	
	// "New" option in dropdown    
	@FindBy(xpath = "//a[@class='actionSearch-menuItem button flyout-menuItem' ][1]")
	public WebElement SearchHistoryNewOption;
	
	// Add Task button in New Shift page    
	@FindBy(xpath = "//button[@data-dyn-controlname='TasksNewButton']")
	public WebElement AddTaskButtonInNewShiftPage;
	
	// Task Name Holder    
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeTaskTmp_TaskName'][@tabindex='0']")
	public WebElement TaskNameHolder;
	
	// Task Description    
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeTaskTmp_TaskDescription'][@tabindex='0']")
	public WebElement TaskDescriptionHolder;	
		
	// Ok Button - New Shift Creation
	@FindBy(xpath = "//button[@data-dyn-controlname='OK']")
	public WebElement OkButton;
	
	// Unassigned Shifts First Profile
	@FindBy(xpath = "//div[1]/div/input[2 and @name='DIA_ResourceUnassignedShifts_Profile']")
	public WebElement UnassignedShiftsFirstProfile;
	
	// Unassigned Shifts Second Profile
	@FindBy(xpath = "//div[2]/div/input[1 and @name='DIA_ResourceUnassignedShifts_Profile']")
	public WebElement UnassignedShifsSecondProfile;
	
	// Task Name Holder    
	@FindBy(xpath = "//input[@name='DIA_ResourceShiftTask_TaskName'][@title='Verifying adding Tasks']")
	public WebElement TaskNameHolderInTasksSection;

	// Task Description    
	@FindBy(xpath = "//input[@name='DIA_ResourceShiftTask_TaskDescription'][@title='Verifying adding Tasks']")
	public WebElement TaskDescriptionHolderInTasksSection;	
	
	// David Pelton Profile Image     
	@FindBy(xpath = "//div[@class='res-resourceCard testclass']//div[@class='res-title' and text()='David Pelton']")
	public WebElement DavidPeltonProfileImage;
	
	// Zac Woodall Profile Image     
	@FindBy(xpath = "//div[@class='res-resourceCard testclass']//div[@class='res-title' and text()='Zac Woodall']")
	public WebElement ZacWoodallProfileImage;
		
	
	/* ********************************* Manual Assignment Of Shifts Page Objects ***************************** */	

	
	// Header Shift   
	@FindBy(xpath = "(//div[@class='section-page-arrow'])[2]")
	public WebElement HeaderShift;
	
	// First Employee Monday Box  
	@FindBy(xpath = "//li[1]/ul[1]/li[1]/div[1]")
	public WebElement FirstEmployeeMondayBox;
	
	// First Employee Tuesday Box  
	@FindBy(xpath = "//li[1]/ul[1]/li[2]/div[1]")
	public WebElement FirstEmployeeTuesdayBox;
	
	// First Employee Wednesday Box  
	@FindBy(xpath = "//li[1]/ul[1]/li[3]/div[1]")
	public WebElement FirstEmployeeWednesdayBox;
	
	// First Employee Thursday Box  
	@FindBy(xpath = "//li[1]/ul[1]/li[4]/div[1]")
	public WebElement FirstEmployeeThursdayBox;
	
	// First Employee Friday Box  
	@FindBy(xpath = "//li[1]/ul[1]/li[4]/div[1]")
	public WebElement FirstEmployeeFridayBox;
	
	// Second employee Monday Box
	@FindBy(xpath = "//li[2]/ul[1]/li[1]/div[1]")
	public WebElement SecondEmployeeMondayBox;
	
	// Second employee Tuesday Box
	@FindBy(xpath = "//li[2]/ul[1]/li[2]/div[1]")
	public WebElement SecondEmployeeTuesdayBox;
	
	// Second employee Wednesday Box
	@FindBy(xpath = "//li[2]/ul[1]/li[3]/div[1]")
	public WebElement SecondEmployeeWednesdayBox;
	
	// Second employee Thursday Box
	@FindBy(xpath = "//li[2]/ul[1]/li[4]/div[1]")
	public WebElement SecondEmployeeThursdayBox;
	
	// Second employee Friday Box
	@FindBy(xpath = "//li[2]/ul[1]/li[5]/div[1]")
	public WebElement SecondEmployeeFridayBox;
	
	// Third Employee Monday Box
	@FindBy(xpath = "//li[3]/ul[1]/li[1]/div[1]")
	public WebElement ThirdEmployeeMondayBox;
	
	// Third employee Tuesday Box
	@FindBy(xpath = "//li[3]/ul[1]/li[2]/div[1]")
	public WebElement ThirdEmployeeTuesdayBox;
	
	// Third employee Wednesday Box
	@FindBy(xpath = "//li[3]/ul[1]/li[3]/div[1]")
	public WebElement ThirdEmployeeWednesdayBox;
	
	// Third employee Thursday Box
	@FindBy(xpath = "//li[3]/ul[1]/li[4]/div[1]")
	public WebElement ThirdEmployeeThursdayBox;
	
	// Third employee Friday Box
	@FindBy(xpath = "//li[3]/ul[1]/li[5]/div[1]")
	public WebElement ThirdEmployeeFridayBox;
	
	// Fourth Employee Monday Box
	@FindBy(xpath = "//li[4]/ul[1]/li[1]/div[1]")
	public WebElement FourthEmployeeMondayBox;
	
	// Fourth Employee Tuesday Box
	@FindBy(xpath = "//li[4]/ul[1]/li[2]/div[1]")
	public WebElement FourthEmployeeTuesdayBox;
	
	// Fourth Employee Wednesday Box
	@FindBy(xpath = "//li[4]/ul[1]/li[3]/div[1]")
	public WebElement FourthEmployeeWednesdayBox;
	
	// Fourth Employee Thursday Box
	@FindBy(xpath = "//li[4]/ul[1]/li[4]/div[1]")
	public WebElement FourthEmployeeThursdayBox;
	
	// Fourth Employee Friday Box
	@FindBy(xpath = "//li[4]/ul[1]/li[5]/div[1]")
	public WebElement FourthEmployeeFridayBox;
	
	// Last Employee Monday Box
	@FindBy(xpath = "//li[13]/ul[1]/li[1]/div[1]")
	public WebElement LastEmployeeMondayBox;
	
	// Last Employee Tuesday Box
	@FindBy(xpath = "//li[13]/ul[1]/li[2]/div[1]")
	public WebElement LastEmployeeTuesdayBox;
	
	// Last Employee Wednesday Box
	@FindBy(xpath = "//li[13]/ul[1]/li[3]/div[1]")
	public WebElement LastEmployeeWednesdayBox;
	
	// Last Employee Thursday Box
	@FindBy(xpath = "//li[13]/ul[1]/li[4]/div[1]")
	public WebElement LastEmployeeThursdayBox;
	
	// Last Employee Friday Box
	@FindBy(xpath = "//li[13]/ul[1]/li[5]/div[1]")
	public WebElement LastEmployeeFridayBox;
	
	// Unassigned Shifts Tab
	@FindBy(xpath = "//li[@data-dyn-controlname='UnassignedShiftsTabPage_header']")
	public WebElement UnassignedShiftsTab;
	
	// First Shift Checkbox
	@FindBy(xpath = "//div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]")
	public WebElement FirstShiftCheckbox;
	
	// Second Shift Checkbox
	@FindBy(xpath = "//div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]")
	public WebElement SecondShiftCheckbox;
	
	// Third Shift Checkbox
	@FindBy(xpath = "//div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/span[1]")
	public WebElement ThirdShiftCheckbox;
	
	// Assign Button
	@FindBy(xpath = "//span[@class='button-label' and text()='Assign']")
	public WebElement AssignButton;
	
	// Blocking Message 
	@FindBy(xpath = "//*[@id='blockingMessage']")
	public WebElement BlockingMessage;
	
	
	/* *********************************AutoAssign/VerifyShiftDetails/CancelAssignments/AdhocTasks/ ****************** */
	/* ************************************PublishShifts/DeleteUnassignedShifts Page Objects ************************* */
	
	// Select All Unassigned Shifts CheckBox 
	@FindBy(xpath = "//div[4]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")
	public WebElement SelectAllUnassignedShiftsCheckBox;
	
	// Select All Assigned Shifts CheckBox 
	@FindBy(xpath = "//div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/span[1]")
	public WebElement SelectAllAssignedShiftsCheckBox;
		
	// Auto Assign Tab 
	@FindBy(xpath = "//button[@data-dyn-controlname='AutoAssign']")
	public WebElement AutoAssignTab;
	
	// Shifts Section Page Arrow 
	@FindBy(xpath = "(//div[@class='section-page-arrow'])[2]")
	public WebElement ShiftsSectionPageArrow;
	
	//  Shifts Details Tab
	@FindBy(xpath = "//li[@data-dyn-controlname='ReservationDetailsTabPageControl_header']")
	public WebElement ShiftDetailsTab;
	
	//  Tasks Tab  
	@FindBy(xpath = "//li[@data-dyn-controlname='TasksTabPage_header']")
	public WebElement TasksTab;
		
	//  Details Of First Shift 
	@FindBy(xpath = "//div[1]/div/input[2 and @name='DIA_ResourceTmpReservationDetails_ShiftTypeId']")
	public WebElement FirstShiftDetails;
	
	//  Details Of Second Shift 
	@FindBy(xpath = "//div[2]/div/input[2 and @name='DIA_ResourceTmpReservationDetails_ShiftTypeId']")
	public WebElement ZacFirstShiftDetails;
	
	//  Cancel Assignments Button    
	@FindBy(xpath = "//button[@data-dyn-controlname='Cancel']")
	public WebElement CancelAssignmentsButton;
	
	//  Publish Button    
	@FindBy(xpath = "//button[@data-dyn-controlname='Publish']")
	public WebElement PublishButton;
	
	// Last Shift Status
	@FindBy(xpath = "//input[@name='DIA_ResourceTmpReservationDetails_Status'][@tabindex='0']")
	public WebElement LastShiftStatus;
	
	// Pop Up YES Button
	@FindBy(xpath = "//button[@data-dyn-controlname='Yes']")
	public WebElement PopUpYesButton;
	
	// Delete Button
	@FindBy(xpath = "//span[@class='button-label' and text()='Delete']")
	public WebElement DeleteButton;
	
	// First Row Of Unassigned Shifts Section
	@FindBy(xpath = "//div[@data-dyn-controlname='UnassignedShiftsGrid_RowTemplate_Row0']")
	public WebElement FirstRowOfUnassignedShifts;
	
	// Workforce Management Parameters Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='Workforce management parameters']")
	public WebElement WorkforceManagementParametersTab;
	
	// Week Start Day   
	@FindBy(xpath = "//input[@name='Roster_WeekStartDay']")
	public WebElement WeekStartDayHolder;
	
	// Wednesday Option   
	@FindBy(xpath = "//li[@role='option'][@aria-label='Wednesday']")
	public WebElement WednesdayOption;
	
	// Monday Option   
	@FindBy(xpath = "//li[@role='option'][@aria-label='Monday']")
	public WebElement MondayOption;
	
	// Tuesday Option   
	@FindBy(xpath = "//li[@role='option'][@aria-label='Tuesday']")
	public WebElement TuesdayOption;
	
	// Thursday Option   
	@FindBy(xpath = "//li[@role='option'][@aria-label='Thursday']")
	public WebElement ThursdayOption;
	
	// Friday Option   
	@FindBy(xpath = "//li[@role='option'][@aria-label='Friday']")
	public WebElement FridayOption;
		
	// First Day In Roster    
	@FindBy(xpath = "//li[@class='av-tim-card av-tim-isHighlighted'][@data-dyn-index='0']")
	public WebElement FirstDayInRoster;
	
	// David Pelton Saturday    
	@FindBy(xpath = "//li[8]/ul[1]/li[6]/div[1]")
	public WebElement DavidPeltonSaturday;
	
	// David Pelton Sunday    
	@FindBy(xpath = "//li[8]/ul[1]/li[7]/div[1]")
	public WebElement DavidPeltonSunday;
	
	// David Pelton Saturday    
	@FindBy(xpath = "//li[8]/ul[1]/li[6]/div[1]")
	public WebElement ZacwoodalSaturday;
	
	// David Pelton Sunday    
	@FindBy(xpath = "//li[8]/ul[1]/li[7]/div[1]")
	public WebElement ZacwoodalSunday;
	
	
	
	
	
	
}
