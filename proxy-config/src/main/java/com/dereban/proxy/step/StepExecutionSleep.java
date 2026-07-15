package com.dereban.proxy.step;

import com.dereban.proxy.dto.Step;
import org.openqa.selenium.WebDriver;

public class StepExecutionSleep  implements StepExecution {
    @Override
    public void execute(WebDriver driver, Step step){
        try{
            Thread.sleep(Long.parseLong(step.getValue()));
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
