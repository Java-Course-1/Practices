package com.dereban.proxy.step;

import com.dereban.proxy.dto.Step;
import org.openqa.selenium.WebDriver;

public class ExecutionService {

    private final StepExecution clickCss;
    private final StepExecution clickXpath;
    private final StepExecution sleep;

    public ExecutionService(StepExecution clickCss,
                            StepExecution clickXpath,
                            StepExecution sleep) {
        this.clickCss = clickCss;
        this.clickXpath = clickXpath;
        this.sleep = sleep;
    }

    public void execute(WebDriver driver, Step step) {
        switch (step.getActionType()) {
            case CLICK -> clickCss.execute(driver, step);
            case CLICK_BY_XPATH -> clickXpath.execute(driver, step);
            case WAIT -> sleep.execute(driver, step);
        }
    }
}