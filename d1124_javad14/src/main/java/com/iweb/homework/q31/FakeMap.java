package com.iweb.homework.q31;

/**
 * @author yiyu
 * @date 2023/11/24 23:39
 */
public interface FakeMap<K,V> {
    V put(K key,V value);

    V get(K key);
}
