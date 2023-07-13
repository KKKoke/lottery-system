package com.kkkoke.lottery.test;

import com.alibaba.fastjson.JSON;
import com.kkkoke.lottery.domain.strategy.model.req.DrawReq;
import com.kkkoke.lottery.domain.strategy.service.draw.IDrawExec;
import com.kkkoke.lottery.infrastructure.dao.IActivityDao;
import com.kkkoke.lottery.infrastructure.po.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

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
}