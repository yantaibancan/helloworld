package com.iweb.homework.q31;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/24 23:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entry<K,V> {
    private K key;
    private V value;

}