package com.dereban.proxy.dto;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class WebDriverConfigTest {

    @Test
    public void constructorAndGetters() {
        ProxyConfigHolder proxy = new ProxyConfigHolder(
                new ProxyNetworkConfig("h", 1),
                new ProxyCredentials("u", "p")
        );
        List<String> args = List.of("--headless", "--no-sandbox");

        WebDriverConfig cfg = new WebDriverConfig(
                "chrome", "125", true, 5, 30, proxy, args
        );

        assertEquals("chrome", cfg.getBrowserName());
        assertEquals("125", cfg.getBrowserVersion());
        assertTrue(cfg.isHeadless());
        assertEquals(5, cfg.getImplicitWaitSeconds());
        assertEquals(30, cfg.getPageLoadTimeoutSeconds());
        assertSame(proxy, cfg.getProxyConfig());
        assertEquals(args, cfg.getBrowserArguments());
    }
}
