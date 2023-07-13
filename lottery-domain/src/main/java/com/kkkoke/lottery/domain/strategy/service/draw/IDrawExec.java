package com.kkkoke.lottery.domain.strategy.service.draw;

import com.kkkoke.lottery.domain.strategy.model.req.DrawReq;
import com.kkkoke.lottery.domain.strategy.model.res.DrawResult;

/**
 * @author KeyCheung
 * @date 2023/07/04
 * @desc 抽奖执行接口
 */
public interface IDrawExec {

    /**
     * 抽奖方法
     */
    DrawResult doDrawExec(DrawReq req);
}