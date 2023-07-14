package com.kkkoke.lottery.infrastructure.dao;

import com.kkkoke.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc
 */
@Mapper
public interface IStrategyDao {

    /**
     * 查询策略配置
     *
     * @param strategyId 策略ID
     * @return           策略配置信息
     */
    Strategy queryStrategy(Long strategyId);

    /**
     * 插入策略配置
     *
     * @param req 策略配置
     */
    void insert(Strategy req);
}