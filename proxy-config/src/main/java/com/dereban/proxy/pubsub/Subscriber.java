package com.dereban.proxy.pubsub;

/**
 * Подписчик на сообщения типа T.
 * Реализация решает, что делать с полученным сообщением.
 */
public interface Subscriber<T> {

    void onMessage(T message);
}
