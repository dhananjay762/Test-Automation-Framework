package com.store.pages;

import org.openqa.selenium.By;

import com.store.utility.Keywords;

public class HomePage extends Keywords{
		
	private By signIn = By.className("login");
	private By signOut = By.className("logout");
	private By searchProductText = By.id("search_query_top");
	private By submit_search = By.name("submit_search");
	private By dressMenu = By.xpath("//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[@title='Dresses']");

	public void goToLogin() {
		ClickOb(signIn);
	}
	
	public void searchForProduct(String product) {
		EnterText(searchProductText, product);
		ClickOb(submit_search);
	}
	
	public void selectDressesMenu() {
		ClickOb(dressMenu);
	}
	
	public void signOut() {
		ClickOb(signOut);
	}

}
