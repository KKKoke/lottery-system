package com.kkkoke.lottery.infrastructure.dao;

import com.kkkoke.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc
 */
@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);
}