package com.dereban.proxy.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProxyNetworkConfigTest {

    @Test
    public void constructorAndGetters() {
        ProxyNetworkConfig n = new ProxyNetworkConfig("proxy.example.com", 8080);
        assertEquals("proxy.example.com", n.getHost());
        assertEquals(8080, n.getPort());
    }
}
