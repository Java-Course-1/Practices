package com.dereban.proxy.dto;


public class ProxyCredentials {
    private String username;
    private String password;

    public ProxyCredentials() {
    }
    public ProxyCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ProxyCredentials{" + "username='" + username + '\'' + ", password='[PROTECTED]'" +'}';
    }
}
