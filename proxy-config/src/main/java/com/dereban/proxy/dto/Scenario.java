package com.dereban.proxy.dto;

import java.util.List;

/**
 * DTO: сценарий = набор шагов.
 * По задаче #69: поля id, name, List<Step>.
 */
public class Scenario {

    private final int id;
    private final String name;
    private final List<Step> steps;

    public Scenario(int id, String name, List<Step> steps) {
        this.id = id;
        this.name = name;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Step> getSteps() {
        return steps;
    }

    @Override
    public String toString() {
        return "Scenario{id=" + id + ", name='" + name + "', steps=" + steps + '}';
    }
}
