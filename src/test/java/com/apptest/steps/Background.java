package com.apptest.steps;

import com.apptest.screens.HomeScreen;

import io.cucumber.java.en.Given;

public class Background {
	
	@Given("^Start with Home screen$")
	public void start_with_Home_screen() throws Throwable {
		new HomeScreen().clickOnHome();
	}


}
