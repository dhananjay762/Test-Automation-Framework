package com.store.pages;

import org.openqa.selenium.By;

import com.store.utility.Keywords;

public class ShoppingPage extends Keywords{
	
	private By casualDressSideMenu = By.xpath("//ul[@class='tree dynamized']/li/a[normalize-space()='Casual Dresses']");
	private By firstProduct = By.xpath("//ul[contains(@class, 'product_list')]/li[1]//img");
	private By more = By.xpath("//span[text()='More']");
	private By addQuantity = By.className("icon-plus");
	private By selectSize = By.id("group_1");
	private By addToCart = By.xpath("//span[text()='Add to cart']");
	private By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
	
	public void clickOnCasualDressMenu() {
		ClickOb(casualDressSideMenu);
	}
	
	public void chooseFirstProduct() {
		ClickOb(firstProduct);
	}
	
	public void clickOnMoreForProduct() {
		HoverOverElement(firstProduct);
		ClickOb(more);
	}
	
	public void chooseQuantity(int quantity) {
		if(quantity>=2) {
			for(int i=0;i<quantity-1;i++) {
				ClickOb(addQuantity);
			}
		}
	}
	
	public void selectSize(String size) {
		SelectByVisibleText(selectSize, size);
	}
	
	public void addToCart() {
		ClickOb(addToCart);
	}
	
	public void doCheckout() {
		ClickOb(proceedToCheckout);
	}

}
