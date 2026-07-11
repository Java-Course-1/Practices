package com.dereban.proxy.dto;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScenarioTest {

    @Test
    public void constructorAndGetters() {
        List<Step> steps = List.of(
                new Step(ActionType.CLICK, "#a", null),
                new Step(ActionType.WAIT, null, "500")
        );

        Scenario sc = new Scenario(42, "Login", steps);
        assertEquals(42, sc.getId());
        assertEquals("Login", sc.getName());
        assertEquals(2, sc.getSteps().size());
        assertEquals(ActionType.WAIT, sc.getSteps().get(1).getActionType());
    }
}
