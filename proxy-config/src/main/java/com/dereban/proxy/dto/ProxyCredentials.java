package com.dereban.proxy.dto;

/**
 * DTO: учётные данные для прокси.
 * Поля неизменяемы (final), задаются только через конструктор.
 */
public class ProxyCredentials {

    private final String username;
    private final String password;

    public ProxyCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ProxyCredentials{username='" + username + "', password='[PROTECTED]'}";
    }
}
