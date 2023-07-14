package com.kkkoke.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.kkkoke.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author KeyCheung
 * @date 2023/07/14
 * @desc 雪花算法
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowFlake;

    @PostConstruct
    public void init() {
        // 0 ~ 31 位，可以采用配置的方式使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowFlake = IdUtil.createSnowflake(workerId, dataCenterId);
    }

    @Override
    public long nextId() {
        return snowFlake.nextId();
    }
}