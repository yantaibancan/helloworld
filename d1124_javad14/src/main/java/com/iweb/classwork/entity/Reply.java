package com.iweb.classwork.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/24 16:21
 */
@Data
@NoArgsConstructor
public class Reply {
    int id;
    String receive;
    String response ;
}
