package com.kkkoke.lottery.domain.award.service.factory;

import com.kkkoke.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc 配送商品简单工厂，提供获取配送服务
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}