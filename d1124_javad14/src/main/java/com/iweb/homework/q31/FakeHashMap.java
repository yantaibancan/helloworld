package com.iweb.homework.q31;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yiyu
 * @date 2023/11/24 23:41
 */
public class FakeHashMap<K,V> implements FakeMap<K,V> {

    List<LinkedList<Entry<K,V>>> list = new ArrayList<>(2000);

    public FakeHashMap()
    {
        for (int i = 0; i < 2000; i++) {
            list.add(null);
        }
    }
    @Override
    public V put(K key, V value) {
        int hashcode = key.hashCode()%2000;

        if(list.get(hashcode)==null)
        {
            list.set(hashcode,new LinkedList<Entry<K,V>>());
            Entry<K,V> entry = new Entry<>(key,value);
            list.get(hashcode).add(entry);
            return value;
        }
        else
        {
            LinkedList<Entry<K,V>> linkedList = list.get(hashcode);
            for (Entry<K,V> entry:linkedList)
            {
                if(entry.getKey().equals(key))
                {
                    entry.setValue(value);
                    return value;
                }
            }

            Entry<K,V> entry=new Entry<>(key,value);
            linkedList.add(entry);
            return value;
        }

    }

    @Override
    public V get(K key) {
        if(key == null)
        {
            return null;
        }
        int hashcode = key.hashCode()%2000;
        if(list.get(hashcode)==null)
        {
            return null;
        }
        else
        {
            LinkedList<Entry<K,V>> linkedList=list.get(hashcode);
            for (Entry<K,V> entry:linkedList) {
                if(entry.getKey().equals(key))
                {
                    return entry.getValue();
                }
            }
        }

        return null;
    }
}
