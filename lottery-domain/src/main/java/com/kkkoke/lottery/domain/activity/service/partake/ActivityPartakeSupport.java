package com.kkkoke.lottery.domain.activity.service.partake;

import com.kkkoke.lottery.domain.activity.model.req.PartakeReq;
import com.kkkoke.lottery.domain.activity.model.vo.ActivityBillVO;
import com.kkkoke.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author KeyCheung
 * @date 2023/07/18
 * @desc 活动领取模操作，一些通用的数据服务
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}