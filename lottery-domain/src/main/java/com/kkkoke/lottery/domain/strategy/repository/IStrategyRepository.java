package com.kkkoke.lottery.domain.strategy.repository;

import com.kkkoke.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.kkkoke.lottery.infrastructure.po.Award;

import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc 策略表仓储服务
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    Award queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     */
    boolean deductStock(Long strategyId, String awardId);
}