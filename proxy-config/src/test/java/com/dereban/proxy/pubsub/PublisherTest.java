package com.dereban.proxy.pubsub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PublisherTest {

    @Test
    public void publishesToAllSubscribers() {
        Publisher<String> pub = new Publisher<>();
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        pub.subscribe(a::add);
        pub.subscribe(b::add);
        assertEquals(2, pub.subscribersCount());

        pub.publish("hi");
        pub.publish("bye");

        assertEquals(List.of("hi", "bye"), a);
        assertEquals(List.of("hi", "bye"), b);
    }

    @Test
    public void unsubscribe() {
        Publisher<Integer> pub = new Publisher<>();
        List<Integer> got = new ArrayList<>();
        Subscriber<Integer> s = got::add;

        pub.subscribe(s);
        pub.publish(1);
        pub.unsubscribe(s);
        pub.publish(2);

        assertEquals(List.of(1), got);
    }
}
