package com.dereban.proxy.dto;

/**
 * DTO для учётных данных прокси.
 * Реализован как record (Java 16+).
 *
 * Что мы получаем автоматически:
 *   - приватные final поля username и password;
 *   - канонический конструктор new ProxyCredentials(username, password);
 *   - геттеры в виде username() и password() (без префикса get);
 *   - корректные equals / hashCode (по значению полей);
 *   - стандартный toString.
 *
 * Здесь toString переопределён, чтобы не светить пароль в логах.
 */
public record ProxyCredentials(String username, String password) {

    @Override
    public String toString() {
        return "ProxyCredentials[username=" + username + ", password=[PROTECTED]]";
    }
}
