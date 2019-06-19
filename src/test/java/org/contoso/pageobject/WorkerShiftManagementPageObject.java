/*
 * Author:	Sachin Kulageri
 * Company:	Wieland IT Solutions Pvt Ltd.
 * Client:	Contoso
 * File:	Login Page Xpaths for logging into Microsoft Dynamics 365*/

package org.contoso.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.contoso.startup.BaseTest;

public class WorkerShiftManagementPageObject extends BaseTest {
WebDriver driver;
	
/* *********************************** Accept Shift page Objects *********************************** */
	
	// Workforce Management To Go To Dashboard
	@FindBy(xpath = "//div[@class='tile modulesFlyout-tile '][@aria-label='Workforce management']")
	public WebElement WorkforceManagementDashboard;
	
	// Configure My Workspace Tab
	@FindBy(xpath = "//button[@data-dyn-controlname='DIA_RosterManagementWorkspaceConfiguration']")
	public WebElement ConfigureMyWorkspaceTab;
	
	// Current Date
	@FindBy(xpath = "//a[@class='ui-state-default ui-state-active']")
	public WebElement CurrentDate;
	
	
	
	
	// Config Workspace Caption  
	@FindBy(xpath = "//div[@class='dialog-caption mainInstruction']")
	public WebElement ConfigWorkspaceCaption;
	
	// Electrical Instr Option  
	@FindBy(xpath = "//input[@class='textbox field displayoption alignmentAuto'][@title='Electrical and Instr']")
	public WebElement ElectricalInstrOption;
	
	// Operatios Option  
	@FindBy(xpath = "//input[@title='Operations']")
	public WebElement OperatiosOption;
	
	// Welding Option  
	@FindBy(xpath = "//input[@title='Welding'] ")
	public WebElement WeldingOption;
	
	// Randwick Power Station Option
	@FindBy(xpath = "//input[@title='Randwick Power Stati']")
	public WebElement RandwickPowerStationOption;
		
	// My First Shift 
	@FindBy(xpath = "//div[@data-dyn-controlname='Grid_RowTemplate_Row0']")
	public WebElement MyFirstShift;
	
	// My Last Shift 
	@FindBy(xpath = "//div[4]/div[1]/span[1]/span[1]")
	public WebElement MyLastShift;
	
	// Swap Request To Be Approved 
	@FindBy(xpath = "//input[@title='Approved waiting']")
	public WebElement SwaprequestToBeApproved;
		
	// My Shift Date Holder 
	@FindBy(xpath = "//input[@name='DialogContent_MyShiftDate']")
	public WebElement MyShiftDateHolder;
	
	// Swap Shift Type 
	@FindBy(xpath = "//input[@name='DialogContent_SwapShift']")
	public WebElement SwapShiftType;
	
	// Workflow Button 
	@FindBy(xpath = "//button[@data-dyn-controlname='DIA_ShiftSwapsWorkflowDropDialog']")
	public WebElement WorkflowButton;
	
	// Workflow Submit Button 
	@FindBy(xpath = "//button[@data-dyn-controlname='PromotedAction1']")
	public WebElement WorkflowSubmitButton;
	
	// Workflow Text Submit Button 
	@FindBy(xpath = "//button[@data-dyn-controlname='Submit']")
	public WebElement WorkflowTextSubmitButton;

	// Workflow Comment Section 
	@FindBy(xpath = "//textarea[@name='Comment']")
	public WebElement WorkflowCommentSection;
		
	// My Swap Requests Link 
	@FindBy(xpath = "//a[@data-dyn-controlname='MyShiftSwaps']")
	public WebElement MySwapRequestsLink;
	
	// All Swap Requests Link 
	@FindBy(xpath = "//a[@data-dyn-controlname='AllShiftSwaps']")
	public WebElement AllSwapRequestsLink;

	// Shift Swap Ok Button 
	@FindBy(xpath = "//button[@data-dyn-controlname='OkButton']")
	public WebElement ShiftSwapOkButton;
	
	// Shift Swap Drafts 
	@FindBy(xpath = "//input[@title='Draft']")
	public WebElement ShiftSwapDrafts;
		
	// Swap With Holder 
	@FindBy(xpath = "//input[@name='DialogContent_SwapWith']")
	public WebElement SwapWithHolder;

	// Swap Shift Date Holder 
	@FindBy(xpath = "//input[@name='DialogContent_SwapShiftDate']")
	public WebElement SwapShiftDateHolder;
	
	// My Unconfirmed Shift 
	@FindBy(xpath = "//span[@name='DIA_ResourceReservationDetails_Status']")
	public WebElement MyUnconfirmedShift;
	
	// Confirm Button in Dashboard
	@FindBy(xpath = "//button[@data-dyn-controlname='Confirm']")
	public WebElement ConfirmButtonInDashboard;
	
		
	// Reject Button in Dashboard
	@FindBy(xpath = "//button[@data-dyn-controlname='Reject']")
	public WebElement RejectButtonInDashboard;
	
	// My Shifts Select All Checkbox
	@FindBy(xpath = "//div[@class='columnHeaderWrapper markingColumnHeader'][@aria-label='Select Rows']")
	public WebElement MyShiftsSelectAllCheckbox;
	
	
	// Swap Request Button in Dashboard
	@FindBy(xpath = "//button[@data-dyn-controlname='SwapRequest']")
	public WebElement SwapRequestButton;
	
	// Unconfirmed Shifts Tile
	@FindBy(xpath = "//div[@data-dyn-controlname='UnconfirmedShifts']")
	public WebElement UnconfirmedShiftsTile;
	
	// Confirmed Shifts Tile
	@FindBy(xpath = "//div[@data-dyn-controlname='ConfirmedShifts']")
	public WebElement ConfirmedShiftsTile;
	
	// Shift Status
	@FindBy(xpath = "//input[@class='textbox field displayoption viewMarker'][@aria-label='Status']")
	public WebElement ShiftStatus;
	
	// Configure Workspace Date Holder 
	@FindBy(xpath = "//input[@name='DIA_RosterManagementWorkspaceConfiguration_DateFilter']")
	public WebElement ConfigureWorkspaceDateHolder;
	
	// Configure Workspace Site Holder 
	@FindBy(xpath = "//input[@name='DIA_RosterManagementWorkspaceConfiguration_InventSiteIdFilter']")
	public WebElement ConfigureWorkspaceSiteHolder;
	
	// Configure Workspace Location Holder 
	@FindBy(xpath = "//input[@name='DIA_RosterManagementWorkspaceConfiguration_LocationNameFilter']")
	public WebElement ConfigureWorkspaceLocationHolder;
	
	// Configure Workspace Main office 
	@FindBy(xpath = "//input[@title='MainOffice']")
	public WebElement ConfigureWorkspaceMainOffice;
	
	
	
	
	
	
}