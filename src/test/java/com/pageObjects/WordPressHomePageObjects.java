package com.pageObjects;

import org.openqa.selenium.By;

public class WordPressHomePageObjects {

	public By displayName() {
		By name = By.xpath("//*[@id='wp-admin-bar-my-account']/a/span");
		return name;
	}
	
	public By siteCustomize() {
		By name = By.xpath("//*[@id=\"welcome-panel\"]/div/div/div[1]/a[1]");
		return name;
	}
}
