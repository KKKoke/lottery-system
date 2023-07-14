package com.kkkoke.lottery.infrastructure.repository;

import com.kkkoke.lottery.common.Constants;
import com.kkkoke.lottery.domain.activity.model.vo.*;
import com.kkkoke.lottery.domain.activity.repository.IActivityRepository;
import com.kkkoke.lottery.infrastructure.dao.IActivityDao;
import com.kkkoke.lottery.infrastructure.dao.IAwardDao;
import com.kkkoke.lottery.infrastructure.dao.IStrategyDao;
import com.kkkoke.lottery.infrastructure.dao.IStrategyDetailDao;
import com.kkkoke.lottery.infrastructure.po.Activity;
import com.kkkoke.lottery.infrastructure.po.Award;
import com.kkkoke.lottery.infrastructure.po.Strategy;
import com.kkkoke.lottery.infrastructure.po.StrategyDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KeyCheung
 * @date 2023/07/14
 * @desc
 */
@Component
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for (AwardVO awardVO : awardList) {
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for (StrategyDetailVO strategyDetailVO : strategyDetailList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState,
                               Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId, ((Constants.ActivityState) beforeState).getCode(),
                ((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }
}