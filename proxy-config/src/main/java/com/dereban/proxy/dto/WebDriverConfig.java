package com.dereban.proxy.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Компактный конфиг WebDriver.
 *
 * Внутри всего три «контейнера»:
 *   - Map<String, String> settings — все простые настройки (browserName, headless, timeouts);
 *   - List<String> browserArguments — аргументы командной строки;
 *   - ProxyConfigHolder proxyConfig — типизированный прокси.
 *
 * Создаётся через WebDriverConfig.builder() с цепочкой методов.
 * Никаких 12 геттеров/сеттеров и громоздкого конструктора больше нет.
 *
 * Trade-off: type-safety мы потеряли — всё, кроме прокси, стало строками.
 * Пользоваться через ключи: cfg.get("browserName").
 *
 * LinkedHashMap, а не HashMap — чтобы порядок добавления сохранялся (важно для вывода).
 */
public class WebDriverConfig {

    private final Map<String, String> settings = new LinkedHashMap<>();
    private final List<String> browserArguments = new ArrayList<>();
    private ProxyConfigHolder proxyConfig;

    private WebDriverConfig() {
        // создаётся только через builder()
    }

    public static Builder builder() {
        return new Builder();
    }

    // --- чтение --------------------------------------------------------

    public String get(String key) {
        return settings.get(key);
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public List<String> getBrowserArguments() {
        return browserArguments;
    }

    public ProxyConfigHolder getProxyConfig() {
        return proxyConfig;
    }

    @Override
    public String toString() {
        return "WebDriverConfig{settings=" + settings
                + ", arguments=" + browserArguments
                + ", proxy=" + proxyConfig + "}";
    }

    // --- Builder -------------------------------------------------------

    public static final class Builder {

        private final WebDriverConfig cfg = new WebDriverConfig();

        /** Добавить любую скалярную настройку: .set("browserName", "chrome"). */
        public Builder set(String key, String value) {
            cfg.settings.put(key, value);
            return this;
        }

        /** Добавить один аргумент командной строки браузера. */
        public Builder addArgument(String arg) {
            cfg.browserArguments.add(arg);
            return this;
        }

        /** Указать прокси (остался типизированным — это не строка). */
        public Builder proxy(ProxyConfigHolder proxy) {
            cfg.proxyConfig = proxy;
            return this;
        }

        public WebDriverConfig build() {
            return cfg;
        }
    }
}
