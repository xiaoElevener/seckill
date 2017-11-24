package org.seckill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dao.SeckillDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
@Slf4j
public class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> result=seckillService.getSeckillList();
        log.info("【getSeckillList】list={}",result);
    }

    @Test
    public void getById() throws Exception {
        long id=1000L;
        Seckill result = seckillService.getById(id);
        log.info("【result】={}", result);
    }

    @Test
    public void seckillLogic() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            log.info("result={}", exposer);
            long phone=134515646L;
            String md5=exposer.getMd5();
            try {
                SeckillExecution execution = seckillService.excuteSeckill(id, phone, md5);
                log.info("execution={}", execution);
            } catch (RepeatKillException e) {
                log.error(e.getMessage());
            } catch (SeckillCloseException e) {
                log.error(e.getMessage());
            }
        }else {
            //秒杀未开启
            log.warn("expose={}",exposer);
        }

        /**
         * result=Exposer(exposed=true, md5=9599d1742f871b9d550507113f4bd695, seckillId=1000, now=0, start=0, end=0)
         */
    }

}