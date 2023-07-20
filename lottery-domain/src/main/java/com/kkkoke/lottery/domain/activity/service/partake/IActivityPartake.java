package com.kkkoke.lottery.domain.activity.service.partake;

import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.domain.activity.model.req.PartakeReq;
import com.kkkoke.lottery.domain.activity.model.res.PartakeResult;
import com.kkkoke.lottery.domain.activity.model.vo.DrawOrderVO;

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

    /**
     * 保存奖品单
     * @param drawOrder 奖品单
     * @return          保存结果
     */
    Result recordDrawOrder(DrawOrderVO drawOrder);
}