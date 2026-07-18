package com.dereban.proxy.webdriver;


import com.dereban.proxy.dto.WebDriverConfig;
import org.openqa.selenium.WebDriver;

public interface WebDriverInitializer {
    WebDriver initialize(WebDriverConfig config);
}
