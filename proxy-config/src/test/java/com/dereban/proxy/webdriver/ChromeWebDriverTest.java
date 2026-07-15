package com.dereban.proxy.webdriver;

import com.dereban.proxy.dto.WebDriverConfig;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ChromeWebDriverTest {

    @Test
    public void shouldOpenWebSite(){
        WebDriverConfig config = new WebDriverConfig(
                "chrome","latest",
                null,
                List.of("--no-sandbox", "--disable-dev-shm-usage")
        );
        ChromeWebDriverInitializer initializer = new ChromeWebDriverInitializer();
        WebDriver webDriver = initializer.initialize(config);

        webDriver.get("https://kino.watch");
        System.out.println("Chrome WebDriver URL: " + webDriver.getTitle());

        webDriver.quit();

    }

}
