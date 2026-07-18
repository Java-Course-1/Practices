package com.dereban.proxy.webdriver;

import com.dereban.proxy.dto.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeWebDriverInitializer implements  WebDriverInitializer {
    @Override
    public WebDriver initialize(WebDriverConfig config){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--crash-dumps-dir=/tmp");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments(config.getBrowserArguments());

        return  new ChromeDriver(options);
    }
}
