package com.dereban.proxy.dto;

/**
 * DTO: конфигурация пула потоков.
 * Поля соответствуют стандартным параметрам ThreadPoolExecutor:
 *   - corePoolSize          — базовый размер пула;
 *   - maxPoolSize           — максимальный размер пула;
 *   - keepAliveTimeSeconds  — сколько сек живут "лишние" потоки без работы;
 *   - queueCapacity         — размер очереди задач;
 *   - threadNamePrefix      — префикс имён потоков для логов.
 */
public class ThreadPoolConfig {

    private final int corePoolSize;
    private final int maxPoolSize;
    private final long keepAliveTimeSeconds;
    private final int queueCapacity;
    private final String threadNamePrefix;

    public ThreadPoolConfig(int corePoolSize,
                            int maxPoolSize,
                            long keepAliveTimeSeconds,
                            int queueCapacity,
                            String threadNamePrefix) {
        this.corePoolSize = corePoolSize;
        this.maxPoolSize = maxPoolSize;
        this.keepAliveTimeSeconds = keepAliveTimeSeconds;
        this.queueCapacity = queueCapacity;
        this.threadNamePrefix = threadNamePrefix;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public long getKeepAliveTimeSeconds() {
        return keepAliveTimeSeconds;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    @Override
    public String toString() {
        return "ThreadPoolConfig{"
                + "corePoolSize=" + corePoolSize
                + ", maxPoolSize=" + maxPoolSize
                + ", keepAliveTimeSeconds=" + keepAliveTimeSeconds
                + ", queueCapacity=" + queueCapacity
                + ", threadNamePrefix='" + threadNamePrefix + '\''
                + '}';
    }
}
