package com.kkkoke.lottery.domain.rule.service.engine;

import com.kkkoke.lottery.domain.rule.model.req.DecisionMatterReq;
import com.kkkoke.lottery.domain.rule.model.res.EngineResult;

/**
 * @author KeyCheung
 * @date 2023/07/20
 * @desc 规则过滤器引擎
 */
public interface EngineFilter {

    /**
     * 规则过滤器接口
     *
     * @param matter      规则决策物料
     * @return            规则决策结果
     */
    EngineResult process(final DecisionMatterReq matter);
}