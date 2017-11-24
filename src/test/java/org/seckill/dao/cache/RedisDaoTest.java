package org.seckill.dao.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.lang.System.out;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
@Slf4j
public class RedisDaoTest {

    private long id=1001;

    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void getSeckill() throws Exception {
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillDao.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                out.println("result的值是:---" + result + ",当前方法=RedisDaoTest,getSeckill()");
                Seckill seckill1= redisDao.getSeckill(id);
                out.println("seckill的值是:---" + seckill + ",当前方法=RedisDaoTest,getSeckill()");
            }
        }
    }

    @Test
    public void putSeckill() throws Exception {
    }

}