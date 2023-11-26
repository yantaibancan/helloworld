package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yiyu
 * @date 2023/11/16 10:41
 */
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String password;
    private String userName;

    public boolean equals(User anotherUser)
    {
        if(this==anotherUser)
        {
            return true;
        }
        if(anotherUser==null)
        {
            return false;
        }
        if(!(this.id == (anotherUser.id)))
        {
            return false;
        }
        if(!this.password.equals(anotherUser.password))
        {
            return false;
        }
        return true;
    }
}
