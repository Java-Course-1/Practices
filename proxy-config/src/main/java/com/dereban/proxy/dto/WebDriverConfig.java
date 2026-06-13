package com.dereban.proxy.dto;


public class WebDriverConfig {
    private String browserName;
    private String browserVersion;
    private boolean isHeadless;
    private int implicitWaitSeconds;
    private int pageLoadTimeoutSeconds;

    private ProxyConfigHolder proxyConfig;

    public WebDriverConfig() {
    }
    public WebDriverConfig(String browserName, String browserVersion, boolean isHeadless, int implicitWaitSeconds, int pageLoadTimeoutSeconds, ProxyConfigHolder proxyConfig) {
        this.browserName = browserName;
        this.browserVersion = browserVersion;
        this.isHeadless = isHeadless;
        this.implicitWaitSeconds = implicitWaitSeconds;
        this.pageLoadTimeoutSeconds = pageLoadTimeoutSeconds;
        this.proxyConfig = proxyConfig;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public boolean isHeadless() {
        return isHeadless;
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
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
    public void setHeadless(boolean headless) {
        this.isHeadless = headless;
    }
    public void setImplicitWaitSeconds(int implicitWaitSeconds) {
        this.implicitWaitSeconds = implicitWaitSeconds;
    }
    public void setPageLoadTimeoutSeconds(int pageLoadTimeoutSeconds) {
        this.pageLoadTimeoutSeconds = pageLoadTimeoutSeconds;
    }
    public void setProxyConfig(ProxyConfigHolder proxyConfig) {
        this.proxyConfig = proxyConfig;
    }

    @Override
    public String toString() {
        return "WebDriverConfig{" +
                "browserName='" + browserName + '\'' +
                ", browserVersion='" + browserVersion + '\'' +
                ", isHeadless=" + isHeadless +
                ", implicitWaitSeconds=" + implicitWaitSeconds +
                ", pageLoadTimeoutSeconds=" + pageLoadTimeoutSeconds +
                ", proxyConfig=" + proxyConfig +
                '}';
    }

}
