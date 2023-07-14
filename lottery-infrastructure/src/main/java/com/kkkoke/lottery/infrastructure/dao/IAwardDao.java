package com.kkkoke.lottery.infrastructure.dao;

import com.kkkoke.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc
 */
@Mapper
public interface IAwardDao {

    /**
     * 查询奖品信息
     *
     * @param awardId 奖品ID
     * @return        奖品信息
     */
    Award queryAwardInfo(String awardId);

    /**
     * 插入奖品配置
     *
     * @param list 奖品配置
     */
    void insertList(List<Award> list);
}