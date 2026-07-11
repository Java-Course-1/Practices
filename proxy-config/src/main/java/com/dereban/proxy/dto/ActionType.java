package com.dereban.proxy.dto;

/**
 * Тип действия шага сценария.
 * По задаче #68: клик, ожидание, клик по XPath.
 */
public enum ActionType {
    CLICK,
    WAIT,
    CLICK_BY_XPATH
}
