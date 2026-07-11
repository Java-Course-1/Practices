package com.dereban.proxy.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StepTest {

    @Test
    public void click() {
        Step s = new Step(ActionType.CLICK, "#login", null);
        assertEquals(ActionType.CLICK, s.getActionType());
        assertEquals("#login", s.getTarget());
        assertNull(s.getValue());
    }

    @Test
    public void wait_() {
        Step s = new Step(ActionType.WAIT, null, "1500");
        assertEquals(ActionType.WAIT, s.getActionType());
        assertNull(s.getTarget());
        assertEquals("1500", s.getValue());
    }

    @Test
    public void clickByXpath() {
        Step s = new Step(ActionType.CLICK_BY_XPATH, "//button[@id='ok']", null);
        assertEquals(ActionType.CLICK_BY_XPATH, s.getActionType());
        assertEquals("//button[@id='ok']", s.getTarget());
    }
}
