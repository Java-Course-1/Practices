package com.dereban.proxy.dto;

/**
 * DTO для сетевого конфига прокси: host + port.
 *
 * Реализовано как record. Внутри объявлен "компактный" конструктор
 * (имя record + скобки без параметров), в котором мы проверяем порт.
 * После проверки компилятор сам присвоит this.host = host и this.port = port —
 * руками писать присваивания НЕ нужно, это особенность records.
 */
public record ProxyNetworkConfig(String host, int port) {

    public ProxyNetworkConfig {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port out of range: " + port);
        }
    }
}
