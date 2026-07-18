package com.dereban.proxy.step;

import com.dereban.proxy.dto.Step;
import org.openqa.selenium.WebDriver;

public interface StepExecution {
    void execute(WebDriver driver, Step step);
}
