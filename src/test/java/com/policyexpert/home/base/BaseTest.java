package com.policyexpert.home.base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.util.Properties;


public abstract class BaseTest {

    public RemoteWebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws IOException {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            prop.load(input);

            switch (prop.getProperty("driver")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }

            driver.navigate().to(prop.getProperty("base_url"));
            driver.manage().window().setSize(new Dimension(
                    Integer.valueOf(prop.getProperty("width")),
                    Integer.valueOf(prop.getProperty("height"))
            ));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        if (driver != null)
            driver.quit();
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

}
