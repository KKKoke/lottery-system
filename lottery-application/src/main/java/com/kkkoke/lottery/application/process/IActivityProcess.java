package com.kkkoke.lottery.application.process;

import com.kkkoke.lottery.application.process.req.DrawProcessReq;
import com.kkkoke.lottery.application.process.res.DrawProcessResult;

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
}