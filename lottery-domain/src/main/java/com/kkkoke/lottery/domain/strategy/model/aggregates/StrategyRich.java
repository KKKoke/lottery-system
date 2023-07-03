package com.kkkoke.lottery.domain.strategy.model.aggregates;

import com.kkkoke.lottery.infrastructure.po.Strategy;
import com.kkkoke.lottery.infrastructure.po.StrategyDetail;

import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/07/02
 * @desc
 */
public class StrategyRich {

    /**
     * 策略 ID
     */
    private Long strategyId;

    /**
     * 策略配置
     */
    private Strategy strategy;

    /**
     * 策略明细
     */
    private List<StrategyDetail> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, Strategy strategy, List<StrategyDetail> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetail> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetail> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}