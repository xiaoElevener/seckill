package org.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 *
 * @author xiao_elevener
 * @create 2017-11-20 22:34
 */
public class RepeatKillException extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
