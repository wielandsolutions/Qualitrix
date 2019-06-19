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

public class LoginPageObject extends BaseTest {
	WebDriver driver;
	
	
	// Email Placeholder
	@FindBy(xpath = "//input[@id='i0116']")
	public WebElement Email;
	
	// Next Button
	@FindBy(xpath = "//input[@id='idSIButton9']")
	public WebElement Next;
	
	// Password Placeholder
	@FindBy(xpath = "//input[@id='i0118']")
	public WebElement Password;
	
	// SignIn Button
	@FindBy(xpath = "//input[@id='idSIButton9']")
	public WebElement Sigin;
	
	// Profile Icon
	@FindBy(xpath="//*[@id='User']/span")
	public WebElement ProfileIcon;
	
	// Sign Out Label
	@FindBy(xpath="//*[@id='SignOut_label']")
	public WebElement SignOut;
	
	// Use Another Account
	@FindBy(xpath="//*[@id='otherTileText']")
	public WebElement UseAnotherAccount;
	
	
	
	//Stay Signed In
	@FindBy(xpath="//*[@id='idSIButton9']")
	public WebElement StaySignedIn;
	
	
	//*[@id="mainPane"]/div[5]/div/div/div
	
	
	
	
	

}

