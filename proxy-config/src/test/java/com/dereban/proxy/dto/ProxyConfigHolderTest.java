package com.dereban.proxy.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ProxyConfigHolderTest {

    @Test
    public void constructorAndGetters() {
        ProxyNetworkConfig n = new ProxyNetworkConfig("h", 1);
        ProxyCredentials c = new ProxyCredentials("u", "p");
        ProxyConfigHolder holder = new ProxyConfigHolder(n, c);

        assertSame(n, holder.getNetworkConfig());
        assertSame(c, holder.getCredentials());
        assertEquals("h", holder.getNetworkConfig().getHost());
        assertEquals("u", holder.getCredentials().getUsername());
    }
}
