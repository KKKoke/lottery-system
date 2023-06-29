package com.kkkoke.lottery.interfaces;

import com.kkkoke.lottery.common.Constants;
import com.kkkoke.lottery.common.Result;
import com.kkkoke.lottery.infrastructure.dao.IActivityDao;
import com.kkkoke.lottery.infrastructure.po.Activity;
import com.kkkoke.lottery.rpc.IActivityBooth;
import com.kkkoke.lottery.rpc.dto.ActivityDto;
import com.kkkoke.lottery.rpc.req.ActivityReq;
import com.kkkoke.lottery.rpc.res.ActivityRes;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @author KeyCheung
 * @date 2023/06/28
 * @desc 活动展台
 */
@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao activityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        ActivityDto activityDto = new ActivityDto();
        activityDto.setActivityId(activity.getActivityId());
        activityDto.setActivityName(activity.getActivityName());
        activityDto.setActivityDesc(activity.getActivityDesc());
        activityDto.setBeginDateTime(activity.getBeginDateTime());
        activityDto.setEndDateTime(activity.getEndDateTime());
        activityDto.setStockCount(activity.getStockCount());
        activityDto.setTakeCount(activity.getTakeCount());

        return new ActivityRes(new Result(Constants.ResponseCode.SUCCESS.getCode(),
                Constants.ResponseCode.SUCCESS.getInfo()), activityDto);
    }
}