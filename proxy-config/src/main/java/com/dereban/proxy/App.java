package com.dereban.proxy;

import com.dereban.proxy.dto.ProxyConfigHolder;
import com.dereban.proxy.dto.ProxyCredentials;
import com.dereban.proxy.dto.ProxyNetworkConfig;
import com.dereban.proxy.dto.WebDriverConfig;

public class App {

    // Ширина таблицы — одна константа, легко менять
    static final int WIDTH = 42;

    public static void main(String[] args) {

        ProxyNetworkConfig networkConfig = new ProxyNetworkConfig("proxy.example.com", 8080);
        ProxyCredentials credentials = new ProxyCredentials("user123", "pass123");
        ProxyConfigHolder configHolder = new ProxyConfigHolder(networkConfig, credentials);
        WebDriverConfig webDriverConfig = new WebDriverConfig("chrome", "latest", true, 10, 30, configHolder);

        printHeader("WEBDRIVER CONFIGURATION");

        printSection("Browser Settings");
        printField("Browser Name",    webDriverConfig.getBrowserName());
        printField("Browser Version", webDriverConfig.getBrowserVersion());
        printField("Headless Mode",   String.valueOf(webDriverConfig.isHeadless()));
        printField("Implicit Wait",   webDriverConfig.getImplicitWaitSeconds() + " sec");
        printField("Page Timeout",    webDriverConfig.getPageLoadTimeoutSeconds() + " sec");

        printSection("Proxy Network");
        printField("Host", webDriverConfig.getProxyConfig().getNetworkConfig().getHost());
        printField("Port", String.valueOf(webDriverConfig.getProxyConfig().getNetworkConfig().getPort()));

        printSection("Proxy Credentials");
        printField("Username", webDriverConfig.getProxyConfig().getCredentials().getUsername());
        printField("Password", "[PROTECTED]");

        printFooter();
    }

    static void printHeader(String title) {
        String line = "+" + "=".repeat(WIDTH) + "+";
        System.out.println();
        System.out.println(line);
        System.out.println("| " + padRight(title, WIDTH - 1) + "|");
        System.out.println(line);
    }

    static void printSection(String name) {
        System.out.println("|" + " ".repeat(WIDTH) + "|");
        System.out.println("| >> " + padRight(name, WIDTH - 4) + "|");
        System.out.println("| " + "-".repeat(WIDTH - 2) + " |");
    }

    static void printField(String label, String value) {
        // Формируем строку вручную чтобы контролировать точную ширину
        String content = "    " + padRight(label, 15) + ": " + value;
        System.out.println("| " + padRight(content, WIDTH - 1) + "|");
    }

    static void printFooter() {
        String line = "+" + "=".repeat(WIDTH) + "+";
        System.out.println("|" + " ".repeat(WIDTH) + "|");
        System.out.println(line);
        System.out.println();
    }

    // Вспомогательный метод — добавляет пробелы справа до нужной длины
    // Если текст длиннее — обрезает
    static String padRight(String text, int length) {
        if (text.length() >= length) {
            return text.substring(0, length);
        }
        return text + " ".repeat(length - text.length());
    }
}