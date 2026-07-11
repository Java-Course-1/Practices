package com.dereban.proxy.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProxyCredentialsTest {

    @Test
    public void constructorAndGetters() {
        ProxyCredentials c = new ProxyCredentials("user", "pass");
        assertEquals("user", c.getUsername());
        assertEquals("pass", c.getPassword());
    }

    @Test
    public void toStringHidesPassword() {
        ProxyCredentials c = new ProxyCredentials("user", "secret");
        String s = c.toString();
        assertEquals(true, s.contains("[PROTECTED]"));
        assertEquals(false, s.contains("secret"));
    }
}
