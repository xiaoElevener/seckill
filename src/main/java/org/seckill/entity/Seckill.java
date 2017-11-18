package org.seckill.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 秒杀商品类
 *
 * @author xiao_elevener
 * @create 2017-11-18 21:19
 */

@Data
public class Seckill {

    private long seckillId;

    private String name;

    private String number;

    private Date startTime;

    private Date endTime;

    private Date createTime;


}
