package com.kkkoke.lottery.test;

import com.alibaba.fastjson.JSON;
import com.kkkoke.lottery.common.Constants;
import com.kkkoke.lottery.domain.award.model.req.GoodsReq;
import com.kkkoke.lottery.domain.award.model.res.DistributionRes;
import com.kkkoke.lottery.domain.award.service.factory.DistributionGoodsFactory;
import com.kkkoke.lottery.domain.award.service.goods.IDistributionGoods;
import com.kkkoke.lottery.domain.strategy.model.req.DrawReq;
import com.kkkoke.lottery.domain.strategy.model.res.DrawResult;
import com.kkkoke.lottery.domain.strategy.model.vo.AwardRateInfo;
import com.kkkoke.lottery.domain.strategy.model.vo.DrawAwardInfo;
import com.kkkoke.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.kkkoke.lottery.domain.strategy.service.draw.IDrawExec;
import com.kkkoke.lottery.infrastructure.dao.IActivityDao;
import com.kkkoke.lottery.infrastructure.dao.IStrategyDetailDao;
import com.kkkoke.lottery.infrastructure.po.Activity;
import com.kkkoke.lottery.infrastructure.po.StrategyDetail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/06/29
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Resource
    IActivityDao activityDao;

    @Resource
    IDrawExec drawExec;

    @Resource
    DistributionGoodsFactory distributionGoodsFactory;

    @Resource
    IStrategyDetailDao strategyDetailDao;

    @Resource(name = "entiretyRateRandomDrawAlgorithm")
    private IDrawAlgorithm randomDrawAlgorithm;

    @Test
    public void testInsert() {
        Activity activity = new Activity();
        activity.setActivityId(100002L);
        activity.setActivityName("测试活动");
        activity.setActivityDesc("仅用于插入数据测试");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(0);
        activity.setCreator("keycheung");
        activityDao.insert(activity);
    }

    @Test
    public void testSelect() {
        Activity activity = activityDao.queryActivityById(100002L);
        logger.info("测试结果：{}", JSON.toJSONString(activity));
    }

    @Test
    public void testDrawExec() {
        drawExec.doDrawExec(new DrawReq("keycheung", 10001L));
    }

    @Test
    public void testStrategyDetailDao() {
        List<StrategyDetail> strategyDetails = strategyDetailDao.queryStrategyDetailList(10001L);
        System.out.println(strategyDetails);
    }

    @Before
    public void init() {
        // 奖品信息
        List<AwardRateInfo> strategyList = new ArrayList<>();
        strategyList.add(new AwardRateInfo("一等奖：IMac", new BigDecimal("0.05")));
        strategyList.add(new AwardRateInfo("二等奖：iphone", new BigDecimal("0.15")));
        strategyList.add(new AwardRateInfo("三等奖：ipad", new BigDecimal("0.20")));
        strategyList.add(new AwardRateInfo("四等奖：AirPods", new BigDecimal("0.25")));
        strategyList.add(new AwardRateInfo("五等奖：充电宝", new BigDecimal("0.35")));

        // 初始数据
        randomDrawAlgorithm.initRateTuple(10001L, strategyList);
    }

    @Test
    public void testAward() {
        // 执行抽奖
        DrawResult drawResult = drawExec.doDrawExec(new DrawReq("keycheung", 10001L));

        // 判断抽奖结果
        Integer drawState = drawResult.getDrawState();
        if (Constants.DrawState.FAIL.getCode().equals(drawState)) {
            logger.info("未中奖 DrawAwardInfo is null");
            return;
        }

        // 封装发奖参数，orderId：2109313442431 为模拟ID，需要在用户参与领奖活动时生成
        DrawAwardInfo drawAwardInfo = drawResult.getDrawAwardInfo();
        GoodsReq goodsReq = new GoodsReq(drawResult.getuId(), "2109313442431", drawAwardInfo.getAwardId(),
                drawAwardInfo.getAwardName(), drawAwardInfo.getAwardContent());

        // 根据 awardType 从抽奖工厂中获取对应的发奖服务
        IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(drawAwardInfo.getAwardType());
        DistributionRes distributionRes = distributionGoodsService.doDistribution(goodsReq);

        logger.info("测试结果：{}", JSON.toJSONString(distributionRes));

    }
}