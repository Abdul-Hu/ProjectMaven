package com.pageObjects;

import org.openqa.selenium.By;
//This is a class that find the element we need from the login page and stores them for later use.
public class WordPressLoginPageObjects {

	//finds the login/username using ID
	public By loginField() {
		By login = By.id("user_login");
		return login;		
	}
	
	//Finds the password field
	public By pwdField() {
		By pwd = By.id("user_pass");
		return pwd;
	}
	
	//Finds the Login Button
	public By clickLogin() {
		By loginClick = By.id("wp-submit");
		return loginClick;
	}
}
