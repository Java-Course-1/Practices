package com.dereban.proxy.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadPoolConfigTest {

    @Test
    public void constructorAndGetters() {
        ThreadPoolConfig p = new ThreadPoolConfig(4, 8, 60L, 100, "worker-");
        assertEquals(4, p.getCorePoolSize());
        assertEquals(8, p.getMaxPoolSize());
        assertEquals(60L, p.getKeepAliveTimeSeconds());
        assertEquals(100, p.getQueueCapacity());
        assertEquals("worker-", p.getThreadNamePrefix());
    }
}
