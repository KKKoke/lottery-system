package com.kkkoke.lottery.domain.strategy.repository.impl;

import com.kkkoke.lottery.domain.strategy.model.aggregates.StrategyRich;
import com.kkkoke.lottery.domain.strategy.repository.IStrategyRepository;
import com.kkkoke.lottery.infrastructure.dao.IAwardDao;
import com.kkkoke.lottery.infrastructure.dao.IStrategyDao;
import com.kkkoke.lottery.infrastructure.dao.IStrategyDetailDao;
import com.kkkoke.lottery.infrastructure.po.Award;
import com.kkkoke.lottery.infrastructure.po.Strategy;
import com.kkkoke.lottery.infrastructure.po.StrategyDetail;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc 策略表仓储服务
 */
@Component
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IAwardDao awardDao;

    @Override
    public StrategyRich queryStrategyRich(Long strategyId) {
        Strategy strategy = strategyDao.queryStrategy(strategyId);
        List<StrategyDetail> strategyDetailList = strategyDetailDao.queryStrategyDetailList(strategyId);
        return new StrategyRich(strategyId, strategy, strategyDetailList);
    }

    @Override
    public Award queryAwardInfo(String awardId) {
        return awardDao.queryAwardInfo(awardId);
    }

    @Override
    public List<String> queryNoStockStrategyAwardList(Long strategyId) {
        return strategyDetailDao.queryNoStockStrategyAwardList(strategyId);
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        StrategyDetail req = new StrategyDetail();
        req.setStrategyId(strategyId);
        req.setAwardId(awardId);
        int count = strategyDetailDao.deductStock(req);
        return count == 1;
    }
}