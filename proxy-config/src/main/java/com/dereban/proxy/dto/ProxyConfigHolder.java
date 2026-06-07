package com.dereban.proxy.dto;
public class ProxyConfigHolder {
    private ProxyNetworkConfig networkConfig;
    private ProxyCredentials credentials;

    public ProxyConfigHolder() {
    }

    public ProxyConfigHolder(ProxyNetworkConfig networkConfig, ProxyCredentials credentials) {
        this.networkConfig = networkConfig;
        this.credentials = credentials;
    }

    public ProxyNetworkConfig getNetworkConfig() {
        return networkConfig;
    }

    public void setNetworkConfig(ProxyNetworkConfig networkConfig) {
        this.networkConfig = networkConfig;
    }

    public ProxyCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(ProxyCredentials credentials) {
        this.credentials = credentials;
    }
    @Override
    public String toString() {
        return "ProxyConfigHolder{" + "networkConfig=" + networkConfig + ", credentials=" + credentials + '}';
    }
}
