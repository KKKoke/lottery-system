package com.kkkoke.lottery.test;

import com.alibaba.fastjson.JSON;
import com.kkkoke.lottery.application.process.IActivityProcess;
import com.kkkoke.lottery.application.process.req.DrawProcessReq;
import com.kkkoke.lottery.application.process.res.DrawProcessResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author KeyCheung
 * @date 2023/07/19
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {

    private Logger logger = LoggerFactory.getLogger(ActivityProcessTest.class);

    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void testDoDrawProcess() {
        DrawProcessReq req = new DrawProcessReq();
        req.setuId("Uhdgkw766120d");
        req.setActivityId(100001L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        logger.info("请求入参：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawProcessResult));
    }

}