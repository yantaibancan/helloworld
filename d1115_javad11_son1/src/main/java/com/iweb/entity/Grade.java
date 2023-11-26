package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author yiyu
 * @date 2023/11/15 18:21
 */
@Data
@NoArgsConstructor
public class Grade {
    private Integer id;
    private String subject;
    private BigDecimal degree;
    private Integer sid;

}
