package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static java.lang.System.out;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        int count=successKilledDao.insertSuccessKilled(1001L, 15722292522L);
        out.println("count的值是:---" + count + ",当前方法=SuccessKilledDaoTest,insertSuccessKilled()");
        /**
         * count的值是:---1,当前方法=SuccessKilledDaoTest,insertSuccessKilled()
         */
    }

    @Test
    public void quertByIdWithSeckill() throws Exception {
        SuccessKilled result = successKilledDao.queryByIdWithSeckill(1000L, 15722292522L);
        out.println("result的值是:---" + result + ",当前方法=SuccessKilledDaoTest,quertByIdWithSeckill()");
        /**
         * result的值是:---SuccessKilled(seckillId=1000, userPhone=15722292522, state=-1, createTime=Sun Nov 19 23:18:39 CST 2017, seckill=Seckill(seckillId=1000, name=1000元秒杀iponeX, number=100, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Sat Nov 18 21:09:30 CST 2017)),当前方法=SuccessKilledDaoTest,quertByIdWithSeckill()
         */
    }

}