package com.dereban.proxy.pubsub;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Публикатор сообщений типа T.
 * При publish() рассылает сообщение всем подписанным Subscriber.
 *
 * Использует CopyOnWriteArrayList — потокобезопасно для чтения при
 * возможных подписках/отписках во время publish() из других потоков.
 */
public class Publisher<T> {

    private final List<Subscriber<T>> subscribers = new CopyOnWriteArrayList<>();

    public void subscribe(Subscriber<T> subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber<T> subscriber) {
        subscribers.remove(subscriber);
    }

    public void publish(T message) {
        for (Subscriber<T> s : subscribers) {
            s.onMessage(message);
        }
    }

    public int subscribersCount() {
        return subscribers.size();
    }
}
