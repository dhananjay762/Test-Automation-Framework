package com.store.pages;

import org.openqa.selenium.By;

import com.store.utility.Keywords;

public class CartPage extends Keywords{
	
	private By proceedToCheckout = By.xpath("//*[@class='cart_navigation clearfix']//*[contains(@class, 'button btn btn-default')]");
	private By acceptToS = By.id("cgv");
	private By payByCheque = By.className("cheque");
	private By confirmOrder = By.xpath("//span[text()='I confirm my order']/parent::button");
	private By successMessage = By.xpath("//p[@class='alert alert-success']");
	
	public void proceedToCheckout() {
		ClickOb(proceedToCheckout);
	}
	
	public void acceptTermsOfCondition() {
		SelectCheckbox(acceptToS);
	}
	
	public void paymentByCheque() {
		ClickOb(payByCheque);
	}
	
	public void confirmMyOrder() {
		ClickOb(confirmOrder);
	}
	
	public void verifySuccessMessage(String text_message) {
		verifyText(successMessage, text_message);
	}

}
