package com.dereban.proxy.dto;

/**
 * DTO: один шаг сценария.
 * Поля:
 *   - actionType — тип действия (CLICK, WAIT, CLICK_BY_XPATH);
 *   - target     — цель (селектор, xpath) или null для WAIT;
 *   - value      — доп. параметр (например, время ожидания в мс для WAIT).
 */
public class Step {

    private final ActionType actionType;
    private final String target;
    private final String value;

    public Step(ActionType actionType, String target, String value) {
        this.actionType = actionType;
        this.target = target;
        this.value = value;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getTarget() {
        return target;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Step{"
                + "actionType=" + actionType
                + ", target='" + target + '\''
                + ", value='" + value + '\''
                + '}';
    }
}
