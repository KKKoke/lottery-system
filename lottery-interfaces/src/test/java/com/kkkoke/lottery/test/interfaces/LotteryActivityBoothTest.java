package com.kkkoke.lottery.test.interfaces;

import com.alibaba.fastjson.JSON;
import com.kkkoke.lottery.rpc.ILotteryActivityBooth;
import com.kkkoke.lottery.rpc.req.DrawReq;
import com.kkkoke.lottery.rpc.req.QuantificationDrawReq;
import com.kkkoke.lottery.rpc.res.DrawRes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author KeyCheung
 * @date 2023/07/25
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryActivityBoothTest {

    private Logger logger = LoggerFactory.getLogger(LotteryActivityBoothTest.class);

    @Resource
    private ILotteryActivityBooth lotteryActivityBooth;

    @Test
    public void testDoDraw() {
        DrawReq drawReq = new DrawReq();
        drawReq.setuId("kkkoke");
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("请求参数：{}", JSON.toJSONString(drawReq));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));
    }

    @Test
    public void testDoQuantificationDraw() {
        QuantificationDrawReq req = new QuantificationDrawReq();
        req.setuId("kkkoke");
        req.setTreeId(2110081902L);
        req.setValMap(new HashMap<String, Object>() {{
            put("gender", "man");
            put("age", "18");
        }});

        DrawRes drawRes = lotteryActivityBooth.doQuantificationDraw(req);
        logger.info("请求参数：{}", JSON.toJSONString(req));
        logger.info("测试结果：{}", JSON.toJSONString(drawRes));
    }
}