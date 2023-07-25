package com.kkkoke.lottery.test.domain;

import com.alibaba.fastjson.JSON;
import com.kkkoke.lottery.domain.rule.model.req.DecisionMatterReq;
import com.kkkoke.lottery.domain.rule.model.res.EngineResult;
import com.kkkoke.lottery.domain.rule.service.engine.EngineFilter;
import com.kkkoke.lottery.test.domain.ActivityTest;
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
 * @date 2023/07/21
 * @desc 规则引擎测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);

    @Resource
    private EngineFilter engineFilter;

    @Test
    public void testProcess() {
        DecisionMatterReq decisionMatterReq = new DecisionMatterReq();
        decisionMatterReq.setTreeId(2110081902L);
        decisionMatterReq.setUserId("kkkkoke");
        decisionMatterReq.setValMap(new HashMap<String, Object>() {{
            put("gender", "man");
            put("age", "25");
        }});

        EngineResult result = engineFilter.process(decisionMatterReq);

        logger.info("请求参数：{}", JSON.toJSONString(decisionMatterReq));
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}