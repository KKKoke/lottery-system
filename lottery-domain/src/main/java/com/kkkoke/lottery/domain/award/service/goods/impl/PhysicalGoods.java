package com.kkkoke.lottery.domain.award.service.goods.impl;

import com.kkkoke.lottery.common.Constants;
import com.kkkoke.lottery.domain.award.model.req.GoodsReq;
import com.kkkoke.lottery.domain.award.model.res.DistributionRes;
import com.kkkoke.lottery.domain.award.service.goods.DistributionBase;
import com.kkkoke.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc 实物发货类商品
 */
@Component
public class PhysicalGoods extends DistributionBase implements IDistributionGoods {

    @Override
    public DistributionRes doDistribution(GoodsReq req) {

        // 模拟调用实物发奖
        logger.info("模拟调用实物发奖 uId：{} awardContent：{}", req.getuId(), req.getAwardContent());

        // 更新用户领奖结果
        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(),
                Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.PhysicalGoods.getCode();
    }
}