package com.Pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ToDoList extends BasePage {
	@FindBy(xpath="//h1[text()='TO DO LIST']")
	private WebElement clickToDoList;
	@FindBy(xpath="//i[@id='plus-icon']")
	private WebElement plusicon;
	@FindBy(xpath="//input[@placeholder='Add new todo']")
	private WebElement add;
	@FindBy(xpath="//li[4]/span/i[@class='fa fa-trash']")
	private WebElement delete;
	public void todolist() {
		clickToDoList.click();
	}
	public void plus_icon() {
		plusicon.click();
	}
	public void add_item(String item) {
	add.sendKeys(item);
	}
	public void del() {
	delete.click();
	}
	 
	}


