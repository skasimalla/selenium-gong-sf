package com.sam.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url= "https://us-9611.app.gong.io/home?workspace-id=2282110384495318159";

		
		WebDriver driver = null;
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
					url);
			System.out.println("Opened URL");

			Thread.sleep(5000);
			//Click on login with salesforce
			//#gongLogin > div.sso-providers > ul > li:nth-child(2) > div > a > span
			driver.findElement(By.xpath("//*[@id=\"gongLogin\"]/div[1]/ul/li[2]/div/a/span")).click();
			Thread.sleep(5000);
			
			
			//Custom domain
			//#mydomainLink
			driver.findElement(By.cssSelector("#mydomainLink")).click();
			Thread.sleep(5000);
			
			//Custom field 
			//#mydomain
			driver.findElement(By.cssSelector("#mydomain")).sendKeys("jfrog"+Keys.RETURN);
			Thread.sleep(5000);
			
			//driver.findElement(By.cssSelector("#mydomainLink")).sendKeys();
			//Thread.sleep(5000);
			
		
			
			//Login with okta
			
			driver.findElement(By.cssSelector(".button.mb12.secondary.wide")).click();
			System.out.println("Clicked Okta");

			Thread.sleep(5000);
			// button select-factor link-button
			driver.findElement(By.cssSelector(".button.select-factor.link-button")).click();
			System.out.println("Clicked fast pass");

			Thread.sleep(20000);//Finger print

			//Click on see all your calls
			//#buttonText-rkum5pofxg
			driver.findElement(By.cssSelector("#buttonText-rkum5pofxg")).click();
			System.out.println("Clicked see all calls");

			
			int x = 1;
			String css1 = "#page-wrapper > div > div > main > div.insights-results-column-wrapper > div.insights-results-wrapper > div.insights-results > ul > li:nth-child("+x+") > div.call-result__main-row > a.call-link.call-thumbnail-icon";
			List<WebElement> e1 = driver.findElements(By.cssSelector(css1));
			while (e1.size() > 0) {
				//Go inside the call page
				e1.get(0).click();
				
				
				//Hamburger button on the right
				//#callActionsButton
				
				
							
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		if (driver != null)
			driver.quit();

	}

	public void setUp() {

	}

}
