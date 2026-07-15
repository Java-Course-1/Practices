package com.dereban.proxy.step;

import com.dereban.proxy.dto.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepExecutionClickXpath implements  StepExecution {
    @Override
    public void execute(WebDriver driver, Step step) {
        driver.findElement(By.xpath(step.getTarget())).click();
    }
}
