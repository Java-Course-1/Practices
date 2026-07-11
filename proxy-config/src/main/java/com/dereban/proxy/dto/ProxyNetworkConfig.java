package com.dereban.proxy.dto;

/**
 * DTO: сетевой конфиг прокси (host + port).
 */
public class ProxyNetworkConfig {

    private final String host;
    private final int port;

    public ProxyNetworkConfig(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ProxyNetworkConfig{host='" + host + "', port=" + port + '}';
    }
}
