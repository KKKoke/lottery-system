package com.kkkoke.lottery.domain.activity.service.partake;

import com.kkkoke.lottery.domain.activity.model.req.PartakeReq;
import com.kkkoke.lottery.domain.activity.model.res.PartakeResult;

/**
 * @author KeyCheung
 * @date 2023/07/14
 * @desc 抽奖活动参与接口
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req 入参
     * @return    领取结果
     */
    PartakeResult doPartake(PartakeReq req);
}