/*
 * Author:	Sachin Kulageri
 * Company:	Wieland IT Solutions Pvt Ltd.
 * Client:	Contoso
 * File:	Login Page Xpaths for logging into Microsoft Dynamics 365*/

package org.contoso.pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.contoso.startup.BaseTest;

public class NewResourceSetupPageObject extends BaseTest {
	WebDriver driver;
	
/* *****************	New Employee Setup Page Objects	 ************* */
	
	// Hamburger
	@FindBy(xpath = "//*[@id='mainPane']/div[5]/div/div/div")
	public WebElement Hamburger;	
	
	// Human Resource Tab
	@FindBy(xpath="//a[text()='Human resources']")
	public WebElement HumanResourceTab;
	
	// Workers Tab
	@FindBy(xpath="//a[@class='modulesFlyout-linkText'][@data-dyn-title='Workers']")
	public WebElement WorkersTab;
	
	// New Worker
	@FindBy(xpath="//button[@data-dyn-controlname='HRNew_Worker']")
	public WebElement NewWorker;
	
	// First Name
	@FindBy(xpath = "//input[@aria-label='First name, Input']")
	public WebElement FirstName;
	
	// Last Name
	@FindBy(xpath = "//input[@aria-label='Last name, Input']")
	public WebElement LastName;
	
	// Employee Start Date
	@FindBy(xpath = "//input[@name='EmploymentStartDate']")
	public WebElement EmployeeStartDate;
	
	// Assignment Start Date
	@FindBy(xpath = "//input[@name='AssignmentStartDate']")
	public WebElement AssignmentStartDate;
		
	// Hire Button
	@FindBy(xpath="(//div[@class='button-container'][contains(.,'Hire')])[1]")
	public WebElement HireButton;
	
	// Cancel Button in Match Found Page
	@FindBy(xpath="//button[@name='CancelButton']")
	public WebElement MatchFoundCancelButton;
	
	// Cancel Button in Match Found Page
	@FindBy(xpath="//div[@aria-label='Match found']")
	public WebElement MatchFoundDialog;
		
	// Filter Search
	@FindBy(xpath = "//input[@aria-label='Filter, Input']")
	public WebElement FilterSearch;
	
	// Apply Filter
	@FindBy(xpath = "//button[contains(@title,'Apply filter')]")
	public WebElement ApplyFilter;
	
	// Check box Name
	@FindBy(xpath = "//input[@name='Name_List']")
	public WebElement CheckName;
	
	// Change Worker Name
	@FindBy(xpath = "//span[contains(.,'Change worker name')]")
	public WebElement ChangeWorkerName;
	
	// Copy Name From First Name Input
	@FindBy(xpath = "//input[contains(@name,'Name_FirstName')]")
	public WebElement CopyName;
	
	// Employee Personnel Number
	@FindBy(xpath = "//input[@name='PersonnelNumber_List']")
	public WebElement EmployeePersonnelNumber;
	
/* *********************** Set Standard Calendar in Resources Page Objects************************** */
	
	// Select Worker 
	@FindBy(xpath = "//span[@class='checkMarkGlyph checkMarkTarget unselectable Checkmark-symbol']")
	public WebElement SelectWorker;
	
	// Project Tab
	@FindBy(xpath = "//span[@class='appBarTab-headerLabel allowFlyoutClickPropagation'][contains(.,'Project')]")
	public WebElement PROJECT;
	
	// Project Setup
	@FindBy(xpath = "//span[contains(.,'Project setup')]")
	public WebElement ProjectSetup;
	
	// Edit Option
	@FindBy(xpath = "(//span[contains(.,'Edit')])[2]")
	public WebElement EditOption;
	
	// Calendar Drop down
	@FindBy(xpath = "//*[@id='ResourceSetup_2_CalendarId']/div/div")
	public WebElement CalendarDropDown;
	
	// Select Calendar
	@FindBy(xpath = "//input[@name='CalendarId']")
	public WebElement SelectCalendar;
	
	// Select Standard Calendar
	@FindBy(xpath = "//div[2]/div[1]/div[2]/div[1]/input[1]")
	public WebElement SelectStandardCalendar;
	
	// Standard Calendar Option
	@FindBy(xpath = "//input[@class='textbox field displayoption viewMarker alignmentAuto'][@title='Standard']")
	public WebElement StandardCalendarOption;
		
	// Save Button
	@FindBy(xpath = "//span[@class='button-commandRing Save-symbol']")
	public WebElement SaveButton;
	
	// Close Button
	@FindBy(xpath = "//span[@class='button-commandRing Cancel-symbol']")
	public WebElement CloseButton;	
	
	// Standard Tool Tip
	@FindBy(xpath = "//span[@class='field-status fieldOptions fieldOptionsShow']")
	public WebElement CalendarToolTip;
	
/*  ************************Set Standard Calendar in Resources Page Objects************************ */
	
	// Organization Administration Tab
	@FindBy(xpath = "//a[text()='Organization administration']")
	public WebElement OrganizationAdministrationTab;
	
	// Resources Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='Resources']")
	public WebElement ResourcesTab;
	
	// Add button
	@FindBy(xpath = "//div[2]/div[2]/button[1]/div[1]")
	public WebElement AddButton;
	
	// Calendar Down Arrow Key
	@FindBy(xpath = "//div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]")
	public WebElement CalendarDownArrowKey;
	
	// StandardCalendar
	@FindBy(xpath = "//input[@name='WrkCtrResourceCalendar_CalendarId']")
	public WebElement StandardCalendar;
	
	// Standard Option
	@FindBy(xpath = "//input[@class='textbox field displayoption viewMarker alignmentAuto'][@title='Standard']")
	public WebElement StandardOption;
	
	
/*   ***********************Update Location Structure PageObjects *****************************/	
	
	// Workforce Management Tab
	@FindBy(xpath = "//a[text()='Workforce management']")
	public WebElement WorkforceManagementTab;
	
	// Location Structure Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='Location structure']")
	public WebElement LocationStructureTab;
	
	// Location Structure Name
	@FindBy(xpath = "//div[@class='Auto input_container layout-ignoreArrange viewContainer hasdiscretesize-width discretesize-width-medium fixed-width editMode']/input")
	public WebElement LocationStructureName;
	
	// Edit
	@FindBy(xpath = "(//span[contains(.,'Edit')])")
	public WebElement Edit;
	
	//  Location dropdown
	@FindBy(xpath = "//li[1]/ul[1]/li[1]/div[1]/button[1]")
	public WebElement LocationDropdown;
	
	// Welding tab
	@FindBy(xpath = "//span[@class='treeView-treeItemLabel '][@title='Welding']")
	public WebElement WeldingTab;
	
	// Operations tab
	@FindBy(xpath = "//span[@class='treeView-treeItemLabel '][@title='Operations']")
	public WebElement OperationsTab;
	
	// Electrical&Istr tab
	@FindBy(xpath = "//span[@class='treeView-treeItemLabel '][@title='Electrical and Instr']")
	public WebElement ElectricalIstrTab;
	
	// Resource Number Holder
	@FindBy(xpath = "//div[1]/div[3]/input[1]")
	public WebElement ResourceNumberHolder;
	
	// Effective Date Holder
	@FindBy(xpath = "//div[5]/div[1]/div[1]/input[1]")
	public WebElement EffectiveDateHolder;

	// Expiration Date Holder
	@FindBy(xpath = "//div[6]/div[1]/div[1]/input[1]")
	public WebElement ExpirationDateHolder;
	
	// Expiration Date Holder
	@FindBy(xpath = "//input[contains(@title,'001105')]")
	public WebElement ExpectedResourceNumber;
	
/* **************************** Initialize Resource Calendar Page Objects ***********************************/
	
	// Initialize Resource calendar Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='Initialize resource calendar']")
	public WebElement InitializeResourceCalendarTab;
	
	// Shift Types Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='Shift types']")
	public WebElement ShiftTypesTab;
	
	// Cleaner Department
	@FindBy(xpath = "//input[@title='Cleaner']")
	public WebElement CleanerDepartment;
	
	//  Add Task
	@FindBy(xpath = "//div[3]/div[1]/div[1]/div[2]/button[1]/div[1]/span[2]")
	public WebElement AddTask;
	
	//  New Task Name
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeTask_TaskName'][@tabindex='0']")
	public WebElement NewTaskName;
	
	//  New Task Description
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeTask_TaskDescription'][@tabindex='0']")
	public WebElement NewTaskDescription;
	
	//  New Task Description
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeTask_DisplayOrder'][@title='4']")
	public WebElement NewTask;
	
	// Delete Task Button
	@FindBy(xpath = "//button[@name='TasksDeleteButton']")
	public WebElement DeleteTaskButton;
	
	// PopUp Yes Button
	@FindBy(xpath = "//button[@data-dyn-controlname='Yes']")
	public WebElement PopUpYesButton;
			
	// Start Date Holder
	@FindBy(xpath = "//div[1]/div[1]/div[1]/input[1]")
	public WebElement StartDateHolder;
	
	// Start Date Holder
	@FindBy(xpath = "//div[2]/div[1]/div[1]/input[1]")
	public WebElement EndDateHolder;
	
	// Remove Existing Records Slider
	@FindBy(xpath = "//span[@class='toggle-box'][@aria-label='Remove existing records']")
	public WebElement RemoveExistingRecordsSlider;
	
	// Remove Existing Records Slider
	@FindBy(xpath = "//span[@class='button-label' and text()='OK']")
	public WebElement OkButton;
	
	// Calendar Initialization Successful dynamic Popup
	@FindBy(xpath = "//*[@id='dynNotificationPopup']/div/div[2]")
	public WebElement SuccessfullInitializationPopup;
	
	// Blocking Message Popup
	@FindBy(xpath = "//*[@id='ShellProcessingDiv']")
	public WebElement BlockingMessagePopup;
	
/* ***************************************** All Schedule Page Objects************************************** */
	
	// All Schedules Tab
	@FindBy(xpath = "//a[@class='modulesFlyout-linkText'][@data-dyn-title='All schedules']")
	public WebElement AllSchedulesTab;
	
	// Site Parameter Holder
	@FindBy(xpath = "//div[2]/div[1]/div[1]/input[1]")
	public WebElement SiteParameterHolder;
	
	// Location Parameter Holder
	@FindBy(xpath = "//div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]")
	public WebElement LocationParameterDropdown;
	
	// Date Parameter Holder
	@FindBy(xpath = "//div[2]/div[2]/div[1]/div[1]/div[1]/input[1]")
	public WebElement DateParameterHolder;
	
	// Schedule Page title
	@FindBy(xpath = "//h1[@class='formCaption' and text()='Schedule']")
	public WebElement SchedulePageTitle;
	
	// Randwick Power station Dropdown
	@FindBy(xpath = "//li[1]/ul[1]/li[1]/div[1]/button[1]")
	public WebElement RandwickPowerstationDropdown;
	
	// Location Dropdown   OkButton
	@FindBy(xpath = "//div[1]/div[2]/button[1]/div[1]/span[2]")
	public WebElement LocationDropdownOkButton;
	
/* ****************************************** Add Certificates and Skills Page objects ***************************** */	

	// Header Worker Tab
	@FindBy(xpath = "//span[@class='appBarTab-headerLabel allowFlyoutClickPropagation' and text()='Worker']")
	public WebElement HeaderWorkerTab;
	
	// Certificates
	@FindBy(xpath = "//span[@class='button-label' and text()='Certificates' ]")
	public WebElement Certificates;
	
	// New Button
	@FindBy(xpath = "//div[1]/div[3]/button[1]/div[1]/span[1]")
	public WebElement NewButton;
	
	// UCD
	@FindBy(xpath = "//div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[20]/div[3]/input[1]")
	public WebElement UCD;
	
	// Certificate Type Dropdown
	@FindBy(xpath = "//input[@name='HcmPersonCertificate_CertificateType_CertificateTypeId']")
	public WebElement CertificateTypePaceHolder;
	
	// Certificate Type Option
	@FindBy(xpath = "//input[@aria-label='Certificate type, Input']")
	public WebElement CertificateTypeOption;
		
	// Start date
	@FindBy(xpath = "//div[2]/div[1]/div[1]/div[1]/input[1]")
	public WebElement StartDate;
	
	// Skills 
	@FindBy(xpath = "//span[@class='button-label' and text()='Skills']")
	public WebElement Skills;
	
	// Skill Holder 
	@FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/input[1]")
	public WebElement SkillHolder;
	
	// Level Holder 
	@FindBy(xpath = "//div[5]/div[1]/div[1]/div[1]/input[1]")
	public WebElement LevelHolder;
	
	// Level Date Holder 
	@FindBy(xpath = "//input[@class='textbox field displayoption viewMarker alignmentLeft'][@name='HcmPersonSkill_RatingLevelDate']")
	public WebElement LevelDateHolder;
	
	// User Centered Design 
	@FindBy(xpath = "//div[3]/div[1]/div[1]/div[1]/input[1]")
	public WebElement UserCenteredDesign;
	
	// Edit Icon 
	@FindBy(xpath = "//span[@class='button-label' and text()='Edit']")
	public WebElement EditIcon;
	
	// Level Dropdown  
	@FindBy(xpath = "//div[5]/div[1]/div[2]/div[1]")
	public WebElement LevelDropdown;
	
	// Novice ForSkills   
	@FindBy(xpath = "//input[@name='HcmRatingLevel_Description'][@title='Novice']")
	public WebElement NoviceForSkills;
	
	// Below Expectation For Goals   
	@FindBy(xpath = "//input[@name='HcmRatingLevel_Description'][@title='Below expectation']")
	public WebElement BelowExpectationForGoals;
	
	// Two For Standard   
	@FindBy(xpath = "//input[@name='HcmRatingLevel_Description'][@title='2']")
	public WebElement TwoForStandard;
	
	// Level Description   
	@FindBy(xpath = "//input[@name='HcmRatingLevel_Description'][@tabindex='0']")
	public WebElement LevelDescription;
	
/* ************************************* Add/Delete Profile Image Page Objects ***************************** */	

	// Image   
	@FindBy(xpath = "//span[@class='button-label' and text()='Image' ]")
	public WebElement Image;
	
	// Browse button
	@FindBy(xpath = "//button[@data-dyn-controlname='FileUploadBrowseButton']")
	public WebElement WorkerImageBrowseButton;
	
	// Worker Image OK Button
	@FindBy(xpath = "//span[@class='button-label' and text()='OK' ]")
	public WebElement WorkerImageOKButton;
	
	// Worker Image OK Button
	@FindBy(id = "inputFile")
	public WebElement FileInput;
	
	// Worker Image Remove Button
	@FindBy(xpath = "//button[@data-dyn-controlname='RemoveImage']")
	public WebElement WorkerImageRemoveButton;
	
	// Worker Image Uploaded
	@FindBy(xpath = "(//img[@class='imageBinder-image'])[5]")
	public WebElement UploadedWorkerImage;

/* **************************************************************************************************************/
	
	// Assistant Operator Tile
	@FindBy(xpath = "(//input[contains(@title,'Assistant operator')])[1]")
	public WebElement AssistantOperatorTile;
	
	// Boiler Maker Tile
	@FindBy(xpath = "(//input[contains(@title,'Boilermaker')])[1]")
	public WebElement BoilerMakerTile;
	
	//Cleaner Tile
	@FindBy(xpath = "(//input[contains(@title,'Cleaner')])[1]")
	public WebElement CleanerTile;
	
	//Electrical Apprentice Tile
	@FindBy(xpath = "(//input[contains(@title,'Elec Apprentice')])[1]")
	public WebElement ElectricalApprenticeTile;
	
	//General Hand
	@FindBy(xpath = "(//input[contains(@title,'General Hand')])[1]")
	public WebElement GeneralHandTile;
	
	// Maint Tech ELec Tile
	@FindBy(xpath = "(//input[contains(@title,'Maint/Tech Elec')])[1]")
	public WebElement MaintTechELecTile;
	
	// Maint Tech Mech Tile
	@FindBy(xpath = "(//input[contains(@title,'Maint/Tech Mech')])[1]")
	public WebElement MaintTechMechTile;
	
	// Maint Tech INC Tile
	@FindBy(xpath = "(//input[contains(@title,'Maint/Tech I&C')])[1]")
	public WebElement MaintTechINCTile;
	
	// Scaffolder Rigger Tile
	@FindBy(xpath = "(//input[contains(@title,'Scaffolder Rigger')])[1]")
	public WebElement ScaffolderRiggerTile;
	
	// Certification Name    
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeCertificate_CertificateType_CertificateTypeId']")
	public WebElement CertificationName;
	
	// Skill Type   
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeSkill_SkillId']")
	public WebElement SkillType;
	
	
	// Level Name   
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeSkill_RatingLevel_HcmRatingModel_RatingModelId']")
	public WebElement LevelName;
	
	// Level Number    
	@FindBy(xpath = "//input[@name='DIA_ShiftTypeSkill_RatingLevel_RatingLevelId']")
	public WebElement LevelNumber;
	
	
	
}

