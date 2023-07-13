package com.kkkoke.lottery.infrastructure.dao;

import com.kkkoke.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author KeyCheung
 * @date 2023/07/13
 * @desc
 */
@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);
}