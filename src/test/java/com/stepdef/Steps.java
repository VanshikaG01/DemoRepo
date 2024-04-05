package com.stepdef;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.Pom.ToDoList;
import Utils.DriverUtils;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Steps {
	ToDoList td = new ToDoList();
@Given("The URL of the website")
public void the_url_of_the_website()throws Exception {
    // Write code here that turns the phrase above into concrete actions
	DriverUtils.getDriver().get("https://webdriveruniversity.com/");
    Thread.sleep(3000);
}

@When("Scroll into view, the to do list option is there")
public void scroll_into_view_the_to_do_list_option_is_there() {
    // Write code here that turns the phrase above into concrete actions
	JavascriptExecutor j=(JavascriptExecutor) DriverUtils.getDriver();
	String scrolldown="window.scrollBy(0,300)";
	j.executeScript(scrolldown);
}

@Then("Click on To Do List button")
public void click_on_to_do_list_button() throws Exception{
    // Write code here that turns the phrase above into concrete actions
	td.todolist();
	Thread.sleep(5000);
}


@Then("Switch to other Tab")
public void switch_to_other_tab()throws Exception {
    // Write code here that turns the phrase above into concrete actions
	String parent_handle = DriverUtils.getDriver().getWindowHandle();
	System.out.println(parent_handle);
	Set<String> handles = DriverUtils.getDriver().getWindowHandles();
	System.out.println(handles);
	for (String handle1 : handles)
		if (!parent_handle.equals(handle1))
		{
			DriverUtils.getDriver().switchTo().window(handle1);
			break;
		}
	   
	Thread.sleep(3000);
}

@Then("Add to new items in the To-do List <{string}>, <{string}>")
public void add_to_new_items_in_the_to_do_list(String string, String string2)throws Exception {
    // Write code here that turns the phrase above into concrete actions
	Thread.sleep(1000);
	td.add_item(string);
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	td.plus_icon();
	td.add_item(string2);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
}

@Then("Print all the items of the list")
public void print_all_the_items_of_the_list() {
    // Write code here that turns the phrase above into concrete actions
	List<WebElement> todoItems = DriverUtils.getDriver().findElements(By.tagName("li"));
	List<WebElement> lastTwoElements = todoItems.subList(Math.max(todoItems.size() - 2, 0), todoItems.size());


	
    for (WebElement item : lastTwoElements) {
        String name = item.getText();
        System.out.println(name);
    }
}


@Then("Delete the newly added items of the list")
public void delete_the_newly_added_items_of_the_list() {
    // Write code here that turns the phrase above into concrete actions
	Actions actions = new Actions(DriverUtils.getDriver());
	WebElement jira = DriverUtils.getDriver().findElement(By.xpath("//li[contains(text(),'Complete Jira Course')]"));
	WebElement cs = DriverUtils.getDriver().findElement(By.xpath("//li[contains(text(),'Case Study')]"));
	actions.moveToElement(jira).sendKeys(Keys.DELETE).build().perform();
	DriverUtils.getDriver().findElement(By.xpath("//li[contains(text(),'Complete Jira Course')]//span")).click();
	actions.moveToElement(cs).sendKeys(Keys.DELETE).build().perform();
	DriverUtils.getDriver().findElement(By.xpath("//li[contains(text(),'Case Study')]//span")).click();

}

@Then("Validate Delete Successfully")
public void validate_delete_successfully() {
    // Write code here that turns the phrase above into concrete actions
	List<WebElement> afterDeletion = DriverUtils.getDriver().findElements(By.tagName("li"));
	boolean isJiraDeleted = true;
	boolean isCaseStudyDeleted = true;
	for(WebElement item : afterDeletion) {
		String name =item.getText();
		if(name.equals("Complete Jira Course")) {
			isJiraDeleted = false;
		}
		else if(name.equals("Case Study")) {
			isCaseStudyDeleted = false;
		}
	}if(isJiraDeleted && isCaseStudyDeleted) {
	 System.out.println("Deleted items are still present in the list ");
        
    }
	else {
		System.out.println("Deleted added items successfully");
	}
} 
}


