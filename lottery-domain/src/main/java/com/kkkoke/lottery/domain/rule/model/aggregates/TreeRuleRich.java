package com.kkkoke.lottery.domain.rule.model.aggregates;

import com.kkkoke.lottery.domain.rule.model.vo.TreeNodeVO;
import com.kkkoke.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * @author KeyCheung
 * @date 2023/07/20
 * @desc 规则树聚合
 */
public class TreeRuleRich {

    /**
     * 树根信息
     */
    private TreeRootVO treeRoot;

    /**
     * 树节点ID -> 子节点
     */
    private Map<Long, TreeNodeVO> treeNodeMap;

    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}