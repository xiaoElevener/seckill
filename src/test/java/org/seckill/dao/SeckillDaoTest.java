package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * 配置spring和junit整合,juint启动加载spring容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {
    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    //update seckill set number = number - 1 where seckill_id = ? and start_time <= ? and end_time >=? and number > 0;
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        out.println("updateCount的值是:---" + updateCount + ",当前方法=SeckillDaoTest,reduceNumber()");
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        out.println("seckill.getName()的值是:---" + seckill.getName() + ",当前方法=SeckillDaoTest,queryById()");
        out.println("seckill的值是:---" + seckill + ",当前方法=SeckillDaoTest,queryById()");
        /**
         * seckill.getName()的值是:---1000元秒杀iponeX,当前方法=SeckillDaoTest,queryById()
         seckill的值是:---Seckill(seckillId=1000, name=1000元秒杀iponeX, number=100, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017),当前方法=SeckillDaoTest,queryById()
         */
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckillList = seckillDao.queryAll(0, 100);
        for (Seckill seckill :
                seckillList) {
            out.println("seckill的值是:---" + seckill + ",当前方法=SeckillDaoTest,queryAll()");
        }
        /**
         * seckill的值是:---Seckill(seckillId=1000, name=1000元秒杀iponeX, number=100, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017),当前方法=SeckillDaoTest,queryAll()
         seckill的值是:---Seckill(seckillId=1001, name=1200元秒杀小米6, number=200, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017),当前方法=SeckillDaoTest,queryAll()
         seckill的值是:---Seckill(seckillId=1002, name=200元秒杀ipad2, number=300, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017),当前方法=SeckillDaoTest,queryAll()
         seckill的值是:---Seckill(seckillId=1003, name=300元秒杀红米note, number=400, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017),当前方法=SeckillDaoTest,queryAll()
         */
    }

}