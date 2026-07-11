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
    private final boolean headless;
    private final int implicitWaitSeconds;
    private final int pageLoadTimeoutSeconds;
    private final ProxyConfigHolder proxyConfig;
    private final List<String> browserArguments;

    public WebDriverConfig(String browserName,
                           String browserVersion,
                           boolean headless,
                           int implicitWaitSeconds,
                           int pageLoadTimeoutSeconds,
                           ProxyConfigHolder proxyConfig,
                           List<String> browserArguments) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.headless = headless;
        this.implicitWaitSeconds = implicitWaitSeconds;
        this.pageLoadTimeoutSeconds = pageLoadTimeoutSeconds;
        this.proxyConfig = proxyConfig;
        this.browserArguments = browserArguments;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public boolean isHeadless() {
        return headless;
    }

    public int getImplicitWaitSeconds() {
        return implicitWaitSeconds;
    }

    public int getPageLoadTimeoutSeconds() {
        return pageLoadTimeoutSeconds;
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
                + ", headless=" + headless
                + ", implicitWaitSeconds=" + implicitWaitSeconds
                + ", pageLoadTimeoutSeconds=" + pageLoadTimeoutSeconds
                + ", proxyConfig=" + proxyConfig
                + ", browserArguments=" + browserArguments
                + '}';
    }
}
