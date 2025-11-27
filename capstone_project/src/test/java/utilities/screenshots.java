package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.messages.internal.com.google.common.io.Files;
import stepdefinition.Hooks;

public class screenshots {
	
	WebDriver driver = Hooks.getDriver();
	
	public void takeScreenshot(String name) throws IOException{
		File srcfile;
		srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcfile, new File("C:\\Selenium demo\\capstone_project\\ScreenshotFolder\\" +name+ ".jpeg"));
	}
}