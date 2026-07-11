package com.dereban.proxy.dto;

/**
 * DTO: пара сетевой конфиг + учётные данные.
 */
public class ProxyConfigHolder {

    private final ProxyNetworkConfig networkConfig;
    private final ProxyCredentials credentials;

    public ProxyConfigHolder(ProxyNetworkConfig networkConfig, ProxyCredentials credentials) {
        this.networkConfig = networkConfig;
        this.credentials = credentials;
    }

    public ProxyNetworkConfig getNetworkConfig() {
        return networkConfig;
    }

    public ProxyCredentials getCredentials() {
        return credentials;
    }

    @Override
    public String toString() {
        return "ProxyConfigHolder{networkConfig=" + networkConfig
                + ", credentials=" + credentials + '}';
    }
}
