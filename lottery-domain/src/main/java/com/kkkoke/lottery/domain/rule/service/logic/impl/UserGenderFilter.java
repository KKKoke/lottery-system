package com.kkkoke.lottery.domain.rule.service.logic.impl;

import com.kkkoke.lottery.domain.rule.model.req.DecisionMatterReq;
import com.kkkoke.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @author KeyCheung
 * @date 2023/07/20
 * @desc 性别规则
 */
@Component
public class UserGenderFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("gender").toString();
    }
}