package com.dereban.proxy;

import com.dereban.proxy.dto.ProxyConfigHolder;
import com.dereban.proxy.dto.ProxyCredentials;
import com.dereban.proxy.dto.ProxyNetworkConfig;
import com.dereban.proxy.dto.WebDriverConfig;

import java.util.Map;

public class App {

    // Ширина таблицы — одна константа, легко менять
    static final int WIDTH = 50;

    public static void main(String[] args) {

        ProxyConfigHolder proxy = new ProxyConfigHolder(
                new ProxyNetworkConfig("proxy.example.com", 8080),
                new ProxyCredentials("user123", "pass123")
        );

        // Всё, что раньше шло позиционными аргументами в конструктор,
        // теперь — пары ключ-значение через .set(...). Порядок не важен,
        // ничего не перепутаешь, лишнее можно не указывать.
        WebDriverConfig cfg = WebDriverConfig.builder()
                .set("browserName",    "chrome")
                .set("browserVersion", "latest")
                .set("headless",       "true")
                .set("implicitWait",   "10 sec")
                .set("pageTimeout",    "30 sec")
                .addArgument("--no-sandbox")
                .addArgument("--disable-gpu")
                .addArgument("--window-size=1920,1080")
                .addArgument("--lang=ru")
                .proxy(proxy)
                .build();

        // --- ВЫВОД ---

        printHeader("WEBDRIVER CONFIGURATION");

        // Скалярные настройки — один цикл по Map. Никаких 5 ручных printField.
        printSection("Browser Settings");
        for (Map.Entry<String, String> e : cfg.getSettings().entrySet()) {
            printField(e.getKey(), e.getValue());
        }

        // Прокси-секции типизированные — через геттеры records.
        printSection("Proxy Network");
        printField("Host", cfg.getProxyConfig().network().host());
        printField("Port", String.valueOf(cfg.getProxyConfig().network().port()));

        printSection("Proxy Credentials");
        printField("Username", cfg.getProxyConfig().credentials().username());
        printField("Password", "[PROTECTED]");

        // Аргументы — цикл по списку.
        printSection("Browser Arguments");
        if (cfg.getBrowserArguments().isEmpty()) {
            printField("(none)", "");
        } else {
            for (String arg : cfg.getBrowserArguments()) {
                printField("set", arg);
            }
        }

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
        String content = "    " + padRight(label, 15) + ": " + value;
        System.out.println("| " + padRight(content, WIDTH - 1) + "|");
    }

    static void printFooter() {
        String line = "+" + "=".repeat(WIDTH) + "+";
        System.out.println("|" + " ".repeat(WIDTH) + "|");
        System.out.println(line);
        System.out.println();
    }

    // Добавляет пробелы справа до нужной длины; длинное НЕ обрезает.
    static String padRight(String text, int length) {
        if (text.length() >= length) {
            return text;
        }
        return text + " ".repeat(length - text.length());
    }
}
