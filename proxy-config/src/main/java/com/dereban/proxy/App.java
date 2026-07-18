package com.dereban.proxy;

import com.dereban.proxy.dto.ActionType;
import com.dereban.proxy.dto.ProxyConfigHolder;
import com.dereban.proxy.dto.ProxyCredentials;
import com.dereban.proxy.dto.ProxyNetworkConfig;
import com.dereban.proxy.dto.Scenario;
import com.dereban.proxy.dto.Step;
import com.dereban.proxy.dto.ThreadPoolConfig;
import com.dereban.proxy.dto.WebDriverConfig;
import com.dereban.proxy.pubsub.Publisher;

import java.util.List;

public class App {

    static final int WIDTH = 50;

    public static void main(String[] args) {

        ProxyNetworkConfig networkConfig = new ProxyNetworkConfig("proxy.example.com", 8080);
        ProxyCredentials credentials = new ProxyCredentials("user123", "pass123");
        ProxyConfigHolder proxyConfig = new ProxyConfigHolder(networkConfig, credentials);

        List<String> browserArguments = List.of(
                "--no-sandbox",
                "--disable-gpu",
                "--window-size=1920,1080",
                "--lang=ru"
        );

        WebDriverConfig webDriverConfig = new WebDriverConfig(
                "chrome", "latest", proxyConfig, browserArguments
        );

        ThreadPoolConfig poolConfig = new ThreadPoolConfig(4, 8, 60L, 100, "worker-");

        Scenario scenario = new Scenario(1, "Login flow", List.of(
                new Step(ActionType.CLICK, "#login-button", null),
                new Step(ActionType.WAIT, null, "1500"),
                new Step(ActionType.CLICK_BY_XPATH, "//input[@name='email']", null)
        ));

        printHeader("WEBDRIVER CONFIGURATION");

        printSection("Browser Settings");
        printField("Browser Name",    webDriverConfig.getBrowserName());
        printField("Browser Version", webDriverConfig.getBrowserVersion());


        printSection("Proxy Network");
        printField("Host", webDriverConfig.getProxyConfig().getNetworkConfig().getHost());
        printField("Port", String.valueOf(webDriverConfig.getProxyConfig().getNetworkConfig().getPort()));

        printSection("Proxy Credentials");
        printField("Username", webDriverConfig.getProxyConfig().getCredentials().getUsername());
        printField("Password", "[PROTECTED]");

        printSection("Browser Arguments");
        for (String arg : webDriverConfig.getBrowserArguments()) {
            printField("arg", arg);
        }

        printSection("Thread Pool");
        printField("Core Pool",       String.valueOf(poolConfig.getCorePoolSize()));
        printField("Max Pool",        String.valueOf(poolConfig.getMaxPoolSize()));
        printField("Keep Alive",      poolConfig.getKeepAliveTimeSeconds() + " sec");
        printField("Queue Capacity",  String.valueOf(poolConfig.getQueueCapacity()));
        printField("Name Prefix",     poolConfig.getThreadNamePrefix());

        printSection("Scenario #" + scenario.getId() + " (" + scenario.getName() + ")");
        for (Step s : scenario.getSteps()) {
            String value = (s.getTarget() != null ? s.getTarget() : "")
                    + (s.getValue() != null ? " [" + s.getValue() + "]" : "");
            printField(s.getActionType().name(), value);
        }

        printFooter();

        Publisher<String> publisher = new Publisher<>();
        publisher.subscribe(m -> System.out.println("  [Sub A] got: " + m));
        publisher.subscribe(m -> System.out.println("  [Sub B] got: " + m));
        System.out.println("Publisher: subscribers = " + publisher.subscribersCount());
        publisher.publish("Event #1");
        publisher.publish("Event #2");
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
        String content = "    " + padRight(label, 15) + ": " + value;
        System.out.println("| " + padRight(content, WIDTH - 1) + "|");
    }

    static void printFooter() {
        String line = "+" + "=".repeat(WIDTH) + "+";
        System.out.println("|" + " ".repeat(WIDTH) + "|");
        System.out.println(line);
        System.out.println();
    }

    static String padRight(String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        return text + " ".repeat(length - text.length());
    }
}
