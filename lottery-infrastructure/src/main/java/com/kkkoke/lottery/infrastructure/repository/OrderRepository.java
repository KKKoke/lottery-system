package com.kkkoke.lottery.infrastructure.repository;

import com.kkkoke.lottery.domain.award.repository.IOrderRepository;
import com.kkkoke.lottery.infrastructure.dao.IUserStrategyExportDao;
import com.kkkoke.lottery.infrastructure.po.UserStrategyExport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author KeyCheung
 * @date 2023/07/21
 * @desc 奖品表仓储服务
 */
@Repository
public class OrderRepository implements IOrderRepository {

    @Resource
    private IUserStrategyExportDao userStrategyExportDao;

    @Override
    public void updateUserAwardState(String uId, Long orderId, String awardId, Integer grantState) {
        UserStrategyExport userStrategyExport = new UserStrategyExport();
        userStrategyExport.setuId(uId);
        userStrategyExport.setOrderId(orderId);
        userStrategyExport.setAwardId(awardId);
        userStrategyExport.setGrantState(grantState);
        userStrategyExportDao.updateUserAwardState(userStrategyExport);
    }
}