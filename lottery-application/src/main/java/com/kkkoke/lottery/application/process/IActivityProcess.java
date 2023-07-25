package com.kkkoke.lottery.application.process;

import com.kkkoke.lottery.application.process.req.DrawProcessReq;
import com.kkkoke.lottery.application.process.res.DrawProcessResult;
import com.kkkoke.lottery.application.process.res.RuleQuantificationCrowdResult;
import com.kkkoke.lottery.domain.rule.model.req.DecisionMatterReq;

/**
 * @author KeyCheung
 * @date 2023/07/19
 * @desc 活动抽奖流程编排接口
 */
public interface IActivityProcess {

    /**
     * 执行抽奖流程
     * @param req 抽奖请求
     * @return    抽奖结果
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);

    /**
     * 规则量化人群，返回可参与的活动ID
     * @param req   规则请求
     * @return      量化结果，用户可以参与的活动ID
     */
    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);
}