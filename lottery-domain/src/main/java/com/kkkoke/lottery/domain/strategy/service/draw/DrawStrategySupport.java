package com.kkkoke.lottery.domain.strategy.service.draw;

import com.kkkoke.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.kkkoke.lottery.domain.strategy.repository.IStrategyRepository;
import com.kkkoke.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * @author KeyCheung
 * @date 2023/07/04
 * @desc 抽奖策略数据支撑，一些通用的数据服务
 */
public class DrawStrategySupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略配置信息
     *
     * @param strategyId 策略ID
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }

    /**
     * 查询奖品详情信息
     *
     * @param awardId 奖品ID
     * @return 中奖详情
     */
    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }
}