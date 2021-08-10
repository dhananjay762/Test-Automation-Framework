package com.store.pages;

import org.openqa.selenium.By;
import com.store.utility.Keywords;

public class SignInPage extends Keywords{
	
	private By email = By.id("email");
	private By passwd = By.id("passwd");
	private By signIn = By.id("SubmitLogin");

	public void enterCredentials(String username, String password) {
		EnterText(email, username);
		EnterText(passwd, password);
	}

	public void clickSignIn() {
		ClickOb(signIn);
	}
	
}
