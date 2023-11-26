package com.iweb.classwork.DAO;

import com.iweb.classwork.entity.Reply;

import java.util.List;

/**提供回复类的模糊查询
 * @author yiyu
 * @date 2023/11/24 16:12
 */
public interface ReplyDao {
    /** 根据用户提供的String内容，通过全模糊筛选回复
     * @param receive 用户提供的String内容，即用户发送内容
     * @return 查询到的回复列表，如果为空，则返回receive为"default"的回复列表
     */
    public List<Reply> listByReceiveLike(String receive);
}
