package org.seckill.exception;

/**
 * 秒杀异常
 *
 * @author xiao_elevener
 * @create 2017-11-20 22:37
 */
public class SeckillException extends  RuntimeException{
    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
