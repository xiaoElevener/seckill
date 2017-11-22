package org.seckill.dto;

import lombok.Data;

/**
 * @author xiao_elevener
 * @create 2017-11-22 21:15
 * 封装json结果
 */
@Data
public class SeckillResult<T> {

    private boolean success;

    private T data;

    private String error;

    public SeckillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
