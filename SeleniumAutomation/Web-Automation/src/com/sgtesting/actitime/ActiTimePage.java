package com.sgtesting.actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTimePage {
	public ActiTimePage(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}
	//WebElement for User Name Text Field
	@FindBy(name ="username")
private WebElement username;
	
	public WebElement getUserName()
	{
		return username;
	}

	//WebElement for Password Text Field
	private WebElement pwd;
	public WebElement getPassword()
	{
		return pwd;
	}

	//WebElement for Login Button
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement oLogin;
	public WebElement getLogin()
	{
		return oLogin;
	}

	//WebElement for FlyOutWindow
	private WebElement gettingStartedShortcutsPanelId;
	public WebElement getFlyOutWindow()
	{
		return gettingStartedShortcutsPanelId;
	}

	//WebElement for  UserButton
	@FindBy(xpath="//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")
	private WebElement userButtons;
	public WebElement getUserButtons() {
		return userButtons;
	}
	
		//WebElement for  AddUserButton
		@FindBy(xpath="//div[text()='Add User']")
		private WebElement AddingUserButton;
		public WebElement getAddingUserButton() {
			return AddingUserButton;
		}

	//WebElement for FirstName
	@FindBy(id="userDataLightBox_firstNameField")
	private WebElement gettingfirstname;
	public WebElement getfirstname()
	{
		return gettingfirstname;
	}
	//WebElement for MiddleName
	@FindBy(id="userDataLightBox_middleNameField")
	private WebElement middleName;
	public WebElement getmiddleName()
	{
		return middleName;
	}
	//WebElement for LastName
	@FindBy(id="userDataLightBox_lastNameField")
	private WebElement lastName;
	public WebElement getlastName()
	{
		return lastName;
	}

	//WebElement for Email
	@FindBy(id="userDataLightBox_emailField")
	private WebElement email;
	public WebElement getemail()
	{
		return email;
	}

	//WebElement for Username1
	@FindBy(id="userDataLightBox_usernameField")
	private WebElement username1;
	public WebElement getusername1()
	{
		return username1;
	}

	//WebElement for Password
	@FindBy(className ="passwordField inputFieldWithPlaceholder")
	private WebElement password;
	public WebElement getpassword()
	{
		return password;
	}

	//WebElement for PasswordCopy
	@FindBy(xpath="//*[@id=\'userDataLightBox_passwordCopyField\']")
	private WebElement passwordCopy;
	public WebElement getpasswordCopy()
	{
		return passwordCopy;
	}

	//WebElement for CreateUserButton
	@FindBy(xpath="//span[text()='Create User']")
	private WebElement createUserButton;
	public WebElement getcreateUserButton()
	{
		return createUserButton;
	}
	//WebElement for Logout Link
	@FindBy(linkText="Logout")
	private WebElement oLogout;
	public WebElement getLogoutLink()
	{
		return oLogout;
	}
	 

}
