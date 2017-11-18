package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * 成功秒杀明细表
 *
 * @author xiao_elevener
 * @create 2017-11-18 21:33
 */
@Data
public class SuccessKilled {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    /*多对一*/
    private Seckill seckill;
}
