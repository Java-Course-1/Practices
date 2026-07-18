package com.dereban.proxy.dto;

import java.util.List;

/**
 * DTO: конфигурация WebDriver.
 * Все поля задаются через конструктор. Никаких билдеров и addArgument.
 * browserArguments — обычный параметр List<String>, читается через геттер.
 */
public class WebDriverConfig {

    private final String browserName;
    private final String browserVersion;
    private final ProxyConfigHolder proxyConfig;
    private final List<String> browserArguments;

    public WebDriverConfig(String browserName,
                           String browserVersion,
                           ProxyConfigHolder proxyConfig,
                           List<String> browserArguments) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.proxyConfig = proxyConfig;
        this.browserArguments = browserArguments;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public ProxyConfigHolder getProxyConfig() {
        return proxyConfig;
    }

    public List<String> getBrowserArguments() {
        return browserArguments;
    }

    @Override
    public String toString() {
        return "WebDriverConfig{"
                + "browserName='" + browserName + '\''
                + ", browserVersion='" + browserVersion + '\''
                + ", proxyConfig=" + proxyConfig
                + ", browserArguments=" + browserArguments
                + '}';
    }
}
