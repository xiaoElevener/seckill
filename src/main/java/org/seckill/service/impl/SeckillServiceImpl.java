package org.seckill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * @author xiao_elevener
 * @create 2017-11-20 22:44
 */
@Slf4j
public class SeckillServiceImpl implements SeckillService {

    private SeckillDao seckillDao;

    private SuccessKilledDao successKilledDao;

    private final String SLAT = "sf5456gsd5-s1b2w.efe6";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if (seckill == null) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();

        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //转化特定字符串的过程
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }


    private String getMD5(long seckillId) {
        String base = seckillId + SLAT;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;

    }

    public SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        try {
            //执行秒杀逻辑
            //1、减库存 2、记录购买行为
            Date nowTime=new Date();
            int update = seckillDao.reduceNumber(seckillId, nowTime);
            if (update <= 0) {
                //没有更新到记录,秒杀结束
                throw new SeckillCloseException("seckill is closed");
            }

            //记录购买行为
            int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
            if(insertCount<=0){
                throw new RepeatKillException("seckill repeat");
            }
            SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);

            return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS,successKilled);
        }catch (SeckillCloseException seckillCloseException){
            throw seckillCloseException;
        }catch (RepeatKillException repeatKillException){
            throw repeatKillException;
        }catch (Exception e){
            log.error("【执行秒杀】message={}",e.getMessage());
            //所有编译器异常转换为运行期异常
            throw new SeckillException("seckill inner error");
        }

    }
}
