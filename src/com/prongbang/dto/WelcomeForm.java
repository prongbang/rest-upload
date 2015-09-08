package com.prongbang.dto;

public class WelcomeForm {

	public String name;
	public String title;

	public WelcomeForm() {
		title = "";
	}

	public WelcomeForm(String inTitle) {
		name = inTitle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
