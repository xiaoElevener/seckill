package org.seckill.exception;

/**
 * 秒杀关闭异常
 *
 * @author xiao_elevener
 * @create 2017-11-20 22:35
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
