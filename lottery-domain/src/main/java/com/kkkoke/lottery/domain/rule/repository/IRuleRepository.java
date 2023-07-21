package com.kkkoke.lottery.domain.rule.repository;

import com.kkkoke.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @author KeyCheung
 * @date 2023/07/20
 * @desc 规则信息仓储服务接口
 */
public interface IRuleRepository {

    /**
     * 查询规则决策树配置
     *
     * @param treeId    决策树ID
     * @return          决策树配置
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}