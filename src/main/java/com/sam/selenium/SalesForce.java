package com.sam.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesForce {

	static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			System.out.println("Start execution");

			Map<String, Object> cloudOptions = new HashMap<>();
			// cloudOptions.put("build", myTestBuild);
			// cloudOptions.put("name", myTestName);

			String remoteURL = "http://localhost:9515";
			ChromeOptions browserOptions = new ChromeOptions();

			browserOptions.setCapability("cloud:options", cloudOptions);
			driver = new RemoteWebDriver(new URL(remoteURL), browserOptions);

			driver.get(
					"https://jfrog.lightning.force.com/lightning/o/Prep_Email__c/list?filterName=00B1r00000AQ7dGEAT");
			System.out.println("Opened URL");

			Thread.sleep(5000);
			driver.findElement(By.cssSelector(".button.mb12.secondary.wide")).click();
			System.out.println("Clicked Okta");

			Thread.sleep(5000);
			// button select-factor link-button
			driver.findElement(By.cssSelector(".button.select-factor.link-button")).click();
			System.out.println("Clicked fast pass");

			Thread.sleep(20000);
			System.out.println("Waited");

			int x = 1;

			boolean keepGoing = true;
			do {
				
				String css1 = "#brandBand_2 > div > div > div.windowViewMode-normal.oneContent.active.lafPageHost > div > div > div.slds-grid.listDisplays.safari-workaround-anchor > div > div.slds-col.slds-no-space.forceListViewManagerPrimaryDisplayManager > div.undefined.forceListViewManagerGrid > div.listViewContent.slds-table--header-fixed_container > div.uiScroller.scroller-wrapper.scroll-bidirectional.native > div > div > table > tbody > tr:nth-child("
						+ x + ") > th";

				String v = "";
				List<WebElement> e1 = driver.findElements(By.cssSelector(css1));
				System.out.println(e1.get(0).getText() + "  " + v);

				String css2 = "#brandBand_2 > div > div > div > div > div > div.slds-grid.listDisplays.safari-workaround-anchor > div > div.slds-col.slds-no-space.forceListViewManagerPrimaryDisplayManager > div.undefined.forceListViewManagerGrid > div.listViewContent.slds-table--header-fixed_container > div.uiScroller.scroller-wrapper.scroll-bidirectional.native > div > div > table > tbody > tr:nth-child("
						+ x + ") > td:nth-child(4)";
				 v = "";
				List<WebElement> e2 = driver.findElements(By.cssSelector(css2));
				v=e2.get(0).getText();
				System.out.println( v);
				
				if(v.length()!=6)
					{
					System.out.println("run create for "+v);
					 openPrep(e1.get(0));
					}
					
					
				Thread.sleep(1000);
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				
				
				
				x++;

			} while (keepGoing);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (driver != null)
			driver.quit();

	}

	private static void openPrep(WebElement e) throws InterruptedException {
		// TODO Auto-generated method stub

		Actions actions = new Actions(driver);
		actions.keyDown(Keys.COMMAND).click(e).build().perform();
		;

		// actions.keyDown(Key);

		Thread.sleep(10000);
		// e.click();
		ArrayList<String> tabs;
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		Thread.sleep(10000);

		List<WebElement> e1 = null;
		

		String xp1 = "//*[contains(text(), 'Create Session')]";
		e1 = driver.findElements(By.xpath(xp1));
		System.out.println("Found2:" + e1.size());
		if (e1.size() > 0)
			e1.get(0).click();

	

		Thread.sleep(5000);

		driver.close();
		tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(0));// Without this it's saying no such window exception

		try {
			e1.get(0).click();
		} catch (Exception e2) {
		}
	}

	public void setUp() {

	}

}
