package com.dereban.proxy;
import com.dereban.proxy.dto.ProxyConfigHolder;
import com.dereban.proxy.dto.ProxyCredentials;
import com.dereban.proxy.dto.ProxyNetworkConfig;

public class App {
    public static void main(String[] args) {
        // Создаем конфигурацию прокси
        ProxyNetworkConfig networkConfig = new ProxyNetworkConfig("proxy.example.com", 8080);
        ProxyCredentials credentials = new ProxyCredentials("user123", "pass123");
        ProxyConfigHolder configHolder = new ProxyConfigHolder(networkConfig, credentials);

        // Выводим конфигурацию
        System.out.println("Proxy Configuration:");
        System.out.println(configHolder);

        System.out.println("\nProxy Network Config:");
        System.out.println(configHolder.getNetworkConfig());
        System.out.println("\nProxy Credentials:");
        System.out.println(configHolder.getCredentials());

        System.out.println("\nProxy Host: " + configHolder.getNetworkConfig().getHost());
        System.out.println("Proxy Port: " + configHolder.getNetworkConfig().getPort()); 
        System.out.println("Proxy Username: " + configHolder.getCredentials().getUsername());
    }
}