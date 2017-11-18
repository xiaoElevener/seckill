package org.seckill.dao;

import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @author xiao_elevener
 * @create 2017-11-18 21:41
 */
public interface SeckillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(long seckillId, Date killTime);

    Seckill queryById(long seckillId);

    List<Seckill> queryAll(int offet,int limit);
}
