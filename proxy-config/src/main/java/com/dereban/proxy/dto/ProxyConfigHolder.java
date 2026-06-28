package com.dereban.proxy.dto;

/**
 * DTO-обёртка над сетью + учётками.
 * Тоже отлично ложится на record — это просто пара значений.
 *
 * Геттеры теперь называются: network() и credentials().
 */
public record ProxyConfigHolder(ProxyNetworkConfig network, ProxyCredentials credentials) {
}
